package com.healthmetrics.core.dto.user;


/**
 * DTO used to register a new user.
 * 
 * @author Gonzalo
 */
public class NewUserDto {

	/** User email. */
	private String email;

	/** User password (ENCRYPTED!). */
	private String password;

	/** First name of the user. */
	private String firstName;

	/** Last name. */
	private String lastName;

	/** @return the email */
	public String getEmail() {
		return email;
	}

	/** @return the password */
	public String getPassword() {
		return password;
	}

	/** @return the firstName */
	public String getFirstName() {
		return firstName;
	}

	/** @return the lastName */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

	/** Constructorcito. */
	public NewUserDto() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public NewUserDto(String email, String password, String firstName, String lastName) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
