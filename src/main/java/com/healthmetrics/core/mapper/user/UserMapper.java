package com.healthmetrics.core.mapper.user;

import java.util.ArrayList;
import java.util.List;

import com.healthmetrics.core.dto.user.UserDto;
import com.healthmetrics.core.model.Role;
import com.healthmetrics.core.model.User;

/**
 * Mapper class for Users.
 * 
 * @author Gonzalo
 */
public abstract class UserMapper {

	/**
	 * Converts a JPA User object to a DTO (does not convert the password!).
	 * 
	 * @param user
	 *            JPA User.
	 * 
	 * @return User DTO.
	 */
	public static UserDto userToUserDto(User user) {
		List<String> roles = new ArrayList<String>(user.getRoles().size());
		for (Role role : user.getRoles()) {
			roles.add(role.getRoleName());
		}
		return new UserDto(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), null, roles);
	}

	/**
	 * Converts a list of JPA User objects to a list of DTOs.
	 * 
	 * @param users
	 *            List of JPA Users.
	 * 
	 * @return List of DTOs.
	 */
	public static List<UserDto> userListToUserDtoList(List<User> users) {
		List<UserDto> list = new ArrayList<UserDto>(users.size());

		for (User user : users) {
			list.add(userToUserDto(user));
		}

		return list;
	}

	// public static User newUserDtoToUser(NewUserDto newUserDto, List<Role> roles) {
	// User newUser = new User();
	// newUser.setEmail(user.getEmail());
	// newUser.setPassword(user.getPassword());
	//
	// Role role = roleRepository.getOne("USER");
	// List<Role> roles = new ArrayList<Role>(1);
	// roles.add(role);
	//
	// newUser.setRoles(roles);
	//
	// return newUser;
	// }
}
