package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the users_relations database table.
 * 
 */
@Entity
@Table(name="users_relations")
@NamedQuery(name="UsersRelation.findAll", query="SELECT u FROM UsersRelation u")
public class UsersRelation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERS_RELATIONSID", unique=true, nullable=false)
	private int usersRelationsid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATE")
	private Date lastUpdate;

	@Column(length=1)
	private String state;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID1")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID2")
	private User user2;

	public UsersRelation() {
	}

	public int getUsersRelationsid() {
		return this.usersRelationsid;
	}

	public void setUsersRelationsid(int usersRelationsid) {
		this.usersRelationsid = usersRelationsid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}