package com.healthmetrics.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.healthmetrics.core.dto.user.NewUserDto;
import com.healthmetrics.core.dto.user.UserDto;
import com.healthmetrics.core.exception.HealthMetricsException;
import com.healthmetrics.core.mapper.user.UserMapper;
import com.healthmetrics.core.model.Role;
import com.healthmetrics.core.model.User;
import com.healthmetrics.core.repository.RoleRepository;
import com.healthmetrics.core.repository.UserRepository;
import com.healthmetrics.core.service.UserManager;
import com.healthmetrics.core.utils.CodeGenerator;
import com.healthmetrics.core.utils.MailSender;

@Service
@Qualifier("userManager")
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MailSender mailSender;

	@Override
	public UserDto findByEmail(String email) throws HealthMetricsException {
		User user = userRepository.findByEmail(email);
		return UserMapper.userToUserDto(user);
	}

	@Override
	public Long registerUser(NewUserDto user) throws HealthMetricsException {
		User existingUser = userRepository.findByEmail(user.getEmail());
		
		Date date = new Date();

		if (existingUser != null) {
			throw new HealthMetricsException("User " + user.getEmail() + " already registered!");
		}

		User newUser = new User();
		newUser.setEmail(user.getEmail());
		newUser.setPassword(user.getPassword());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getEmail());
		newUser.setRegistrationdate(date);
		newUser.setGender("M");
		newUser.setHeight(0);
		newUser.setWeight(0);
		newUser.setType(1);
		newUser.setSessionsweek(3);
		newUser.setRecoveryToken("fdf");
		
		

		Role role = roleRepository.getOne("USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);

		newUser.setRoles(roles);

		User savedUser = userRepository.save(newUser);

		return savedUser.getId();
	}

	@Override
	public List<UserDto> findAll() throws HealthMetricsException {
		List<User> allUsers = userRepository.findAll();
		return UserMapper.userListToUserDtoList(allUsers);
	}

	@Override
	public void sendPasswordResetEmail(String baseUrl, String email) throws HealthMetricsException {
		String token = CodeGenerator.generateCode();
		if (!userRepository.savePasswordRecoveryToken(email, token)) {
			throw new HealthMetricsException("forgotpassword.error.invaliduser");
		}

		mailSender.sendPasswordResetEmail(baseUrl, email, token + userRepository.findByEmail(email).getId());
	}

	@Override
	public boolean checkRecoveryToken(String token) throws HealthMetricsException {
		try {
			Long userId = Long.parseLong(CodeGenerator.getExtraContentFromCode(token));
			return userRepository.checkPasswordRecoveryToken(userId, CodeGenerator.getCodeWithoutExtraContent(token));
		} catch (NumberFormatException e) {
			throw new HealthMetricsException("Invalid token");
		}
	}

	@Override
	public void updateUserPassword(String email, String password) throws HealthMetricsException {
		userRepository.saveNewPasswordAndClearToken(email, password);
	}

	@Override
	public String getEmailById(Long id) throws HealthMetricsException {
		return userRepository.getOne(id).getEmail();
	}
	@Override
	public Long updateUser(UserDto user) throws HealthMetricsException {
		User existingUser = userRepository.findByEmail(user.getEmail());

		if (existingUser == null) {
			throw new HealthMetricsException("User " + user.getEmail() + " does not exist!");
		}

		if (existingUser.getId() != user.getId()) {
			throw new HealthMetricsException("Trying to update user with id " + existingUser.getId()
					+ " with data from user " + user.getId());
		}

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());

		if (StringUtils.isNotBlank(user.getPassword())) {
			existingUser.setPassword(user.getPassword());
		}

		User savedUser = userRepository.save(existingUser);

		return savedUser.getId();
	}

	@Override
	public UserDto findById(Long userId) throws HealthMetricsException {
		return UserMapper.userToUserDto(userRepository.findOne(userId));
	}
}
