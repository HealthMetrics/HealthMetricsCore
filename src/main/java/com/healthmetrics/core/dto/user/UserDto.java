package com.healthmetrics.core.dto.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO used to return the data of user.
 * 
 * @author Gonzalo
 */
public class UserDto {

	/** User identifier. */
	private Long id;

	/** User email. */
	private String email;

	/** First name of the user. */
	private String firstName;

	/** Last name. */
	private String lastName;

	/** Password - Will be always empty except when updating the user. */
	private String password;

	/** User roles. */
	private List<String> roles;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return new ArrayList<String>(roles);
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/**
	 * Constructor.
	 * 
	 * @param id
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @param roles
	 */
	public UserDto(Long id, String email, String firstName, String lastName, String password, List<String> roles) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.roles = new ArrayList<String>(roles);
	}

	/** Constructorcito. */
	public UserDto() {
		super();
	}

}
