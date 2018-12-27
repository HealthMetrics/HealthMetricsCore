package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the activities database table.
 * 
 */
@Entity
@Table(name="activities")
@NamedQuery(name="Activity.findAll", query="SELECT a FROM Activity a")
public class Activity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int activityid;

	@Column(length=45)
	private String description;

	@Column(length=45)
	private String name;

	@Column(length=1)
	private String type;

	//bi-directional many-to-one association to RoutinesTraining
	@OneToMany(mappedBy="activity")
	private List<RoutinesTraining> routinesTrainings;

	//bi-directional many-to-one association to TrainingSession
	@OneToMany(mappedBy="activity")
	private List<TrainingSession> trainingSessions;

	public Activity() {
	}

	public int getActivityid() {
		return this.activityid;
	}

	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<RoutinesTraining> getRoutinesTrainings() {
		return this.routinesTrainings;
	}

	public void setRoutinesTrainings(List<RoutinesTraining> routinesTrainings) {
		this.routinesTrainings = routinesTrainings;
	}

	public RoutinesTraining addRoutinesTraining(RoutinesTraining routinesTraining) {
		getRoutinesTrainings().add(routinesTraining);
		routinesTraining.setActivity(this);

		return routinesTraining;
	}

	public RoutinesTraining removeRoutinesTraining(RoutinesTraining routinesTraining) {
		getRoutinesTrainings().remove(routinesTraining);
		routinesTraining.setActivity(null);

		return routinesTraining;
	}

	public List<TrainingSession> getTrainingSessions() {
		return this.trainingSessions;
	}

	public void setTrainingSessions(List<TrainingSession> trainingSessions) {
		this.trainingSessions = trainingSessions;
	}

	public TrainingSession addTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().add(trainingSession);
		trainingSession.setActivity(this);

		return trainingSession;
	}

	public TrainingSession removeTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().remove(trainingSession);
		trainingSession.setActivity(null);

		return trainingSession;
	}

}