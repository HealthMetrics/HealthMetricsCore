package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@XmlRootElement(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long id;

	@Column(nullable=false, length=200)
	private String email;

	@Column(name="first_name", nullable=false, length=200)
	private String firstName;

	@Column(nullable=false, length=1)
	private String gender;

	@Column(nullable=false)
	private float height;

	@Column(name="last_name", nullable=false, length=200)
	private String lastName;

	@Column(nullable=false, length=100)
	private String password;

	@Column(name="recovery_token", nullable=false, length=50)
	private String recoveryToken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date registrationdate;

	private int sessionsweek;

	@Column(nullable=false)
	private int type;

	@Column(nullable=false, length=45)
	private String username;

	@Column(nullable=false)
	private float weight;

	//bi-directional many-to-one association to Training
	@OneToMany(mappedBy="user1")
	private List<Training> trainings1;

	//bi-directional many-to-one association to Training
	@OneToMany(mappedBy="user2")
	private List<Training> trainings2;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="user_role"
		, joinColumns={
			@JoinColumn(name="id_user", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="role", nullable=false)
			}
		)
	private List<Role> roles;

	//bi-directional many-to-one association to UsersRelation
	@OneToMany(mappedBy="user1")
	private List<UsersRelation> usersRelations1;

	//bi-directional many-to-one association to UsersRelation
	@OneToMany(mappedBy="user2")
	private List<UsersRelation> usersRelations2;

	public User() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getHeight() {
		return this.height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecoveryToken() {
		return this.recoveryToken;
	}

	public void setRecoveryToken(String recoveryToken) {
		this.recoveryToken = recoveryToken;
	}

	public Date getRegistrationdate() {
		return this.registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public int getSessionsweek() {
		return this.sessionsweek;
	}

	public void setSessionsweek(int sessionsweek) {
		this.sessionsweek = sessionsweek;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public List<Training> getTrainings1() {
		return this.trainings1;
	}

	public void setTrainings1(List<Training> trainings1) {
		this.trainings1 = trainings1;
	}

	public Training addTrainings1(Training trainings1) {
		getTrainings1().add(trainings1);
		trainings1.setUser1(this);

		return trainings1;
	}

	public Training removeTrainings1(Training trainings1) {
		getTrainings1().remove(trainings1);
		trainings1.setUser1(null);

		return trainings1;
	}

	public List<Training> getTrainings2() {
		return this.trainings2;
	}

	public void setTrainings2(List<Training> trainings2) {
		this.trainings2 = trainings2;
	}

	public Training addTrainings2(Training trainings2) {
		getTrainings2().add(trainings2);
		trainings2.setUser2(this);

		return trainings2;
	}

	public Training removeTrainings2(Training trainings2) {
		getTrainings2().remove(trainings2);
		trainings2.setUser2(null);

		return trainings2;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<UsersRelation> getUsersRelations1() {
		return this.usersRelations1;
	}

	public void setUsersRelations1(List<UsersRelation> usersRelations1) {
		this.usersRelations1 = usersRelations1;
	}

	public UsersRelation addUsersRelations1(UsersRelation usersRelations1) {
		getUsersRelations1().add(usersRelations1);
		usersRelations1.setUser1(this);

		return usersRelations1;
	}

	public UsersRelation removeUsersRelations1(UsersRelation usersRelations1) {
		getUsersRelations1().remove(usersRelations1);
		usersRelations1.setUser1(null);

		return usersRelations1;
	}

	public List<UsersRelation> getUsersRelations2() {
		return this.usersRelations2;
	}

	public void setUsersRelations2(List<UsersRelation> usersRelations2) {
		this.usersRelations2 = usersRelations2;
	}

	public UsersRelation addUsersRelations2(UsersRelation usersRelations2) {
		getUsersRelations2().add(usersRelations2);
		usersRelations2.setUser2(this);

		return usersRelations2;
	}

	public UsersRelation removeUsersRelations2(UsersRelation usersRelations2) {
		getUsersRelations2().remove(usersRelations2);
		usersRelations2.setUser2(null);

		return usersRelations2;
	}

}