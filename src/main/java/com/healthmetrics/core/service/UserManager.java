package com.healthmetrics.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthmetrics.core.dto.user.NewUserDto;
import com.healthmetrics.core.dto.user.UserDto;
import com.healthmetrics.core.exception.HealthMetricsException;

@Service
public interface UserManager {

	/**
	 * Gets the email of a user given his id.
	 * 
	 * @param id
	 *            Id.
	 * 
	 * @return The email of the user.
	 * 
	 * @throws HealthMetricsException
	 */
	public String getEmailById(Long id) throws HealthMetricsException;

	/**
	 * Returns a list with all registered users.
	 * 
	 * @return List with registered users.
	 * 
	 * @throws HealthMetricsException
	 */
	public List<UserDto> findAll() throws HealthMetricsException;

	/**
	 * Returns a user given an email.
	 * 
	 * @param email
	 *            Email to look for.
	 * @return The data of the user.
	 * 
	 * @throws HealthMetricsException
	 */
	public UserDto findByEmail(String email) throws HealthMetricsException;

	/**
	 * Registers a new user in the platform.
	 * 
	 * @param user
	 *            Data of the user to be registered in the platform.
	 * 
	 * @return The identifier of the newly created user.
	 * 
	 * @throws HealthMetricsException
	 */
	public Long registerUser(NewUserDto user) throws HealthMetricsException;

	/**
	 * Sends a password reset email to a user.
	 * 
	 * @param baseUrl
	 *            Base URL of the server.
	 * @param email
	 *            Email of the user.
	 * 
	 * @throws HealthMetricsException
	 */
	public void sendPasswordResetEmail(String baseUrl, String email) throws HealthMetricsException;

	/**
	 * Checkes whether a password reset token exists.
	 * 
	 * @param token
	 *            Token to check.
	 * 
	 * @return True if the token exists, false otherwise.
	 * 
	 * @throws HealthMetricsException
	 */
	public boolean checkRecoveryToken(String token) throws HealthMetricsException;

	/**
	 * Updates the password for a user.
	 * 
	 * @param email
	 *            Email of the user.
	 * @param password
	 *            New password (already encrypted!).
	 * 
	 * @throws HealthMetricsException
	 */
	public void updateUserPassword(String email, String password) throws HealthMetricsException;

	/**
	 * Updates the information of a user in the platform.
	 * 
	 * @param user
	 *            User to update.
	 * 
	 * @return The identifier of the user.
	 * 
	 * @throws ConnectBirdsException
	 */
	public Long updateUser(UserDto user) throws HealthMetricsException;
	
	/**
	 * Returns a user given the user id
	 * 
	 * @param userId
	 *            id to look for.
	 * @return The data of the user.
	 * 
	 * @throws ConnectBirdsException
	 */
	public UserDto findById(Long userId) throws HealthMetricsException;
}
