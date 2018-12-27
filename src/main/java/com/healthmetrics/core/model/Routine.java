package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the routines database table.
 * 
 */
@Entity
@Table(name="routines")
@NamedQuery(name="Routine.findAll", query="SELECT r FROM Routine r")
public class Routine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int routineid;

	@Column(length=45)
	private String description;

	@Column(length=45)
	private String name;

	@Column(length=1)
	private String type;

	//bi-directional many-to-one association to RoutinesTraining
	@OneToMany(mappedBy="routine")
	private List<RoutinesTraining> routinesTrainings;

	//bi-directional many-to-one association to TrainingSession
	@OneToMany(mappedBy="routine")
	private List<TrainingSession> trainingSessions;

	public Routine() {
	}

	public int getRoutineid() {
		return this.routineid;
	}

	public void setRoutineid(int routineid) {
		this.routineid = routineid;
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
		routinesTraining.setRoutine(this);

		return routinesTraining;
	}

	public RoutinesTraining removeRoutinesTraining(RoutinesTraining routinesTraining) {
		getRoutinesTrainings().remove(routinesTraining);
		routinesTraining.setRoutine(null);

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
		trainingSession.setRoutine(this);

		return trainingSession;
	}

	public TrainingSession removeTrainingSession(TrainingSession trainingSession) {
		getTrainingSessions().remove(trainingSession);
		trainingSession.setRoutine(null);

		return trainingSession;
	}

}