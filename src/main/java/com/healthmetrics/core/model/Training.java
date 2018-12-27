package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trainings database table.
 * 
 */
@Entity
@Table(name="trainings")
@NamedQuery(name="Training.findAll", query="SELECT t FROM Training t")
public class Training implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int trainingid;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(length=45)
	private String description;

	@Column(length=1)
	private String finished;

	@Column(length=45)
	private String name;

	//bi-directional many-to-one association to TrainingSession
	@OneToMany(mappedBy="training")
	private List<TrainingSession> trainingSessions;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID", nullable=false)
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ADMINID", nullable=false)
	private User user2;

	public Training() {
	}

	public int getTrainingid() {
		return this.trainingid;
	}

	public void setTrainingid(int trainingid) {
		this.trainingid = trainingid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFinished() {
		return this.finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TrainingSession> getTrainingSessions() {
		return this.trainingSessions;
	}

	public void setTrainingSessions(List<TrainingSession> trainingSessions) {
		this.trainingSessions = trainingSessions;
	}

	public TrainingSession addTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().add(trainingSession);
		trainingSession.setTraining(this);

		return trainingSession;
	}

	public TrainingSession removeTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().remove(trainingSession);
		trainingSession.setTraining(null);

		return trainingSession;
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