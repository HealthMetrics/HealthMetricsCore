package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the training_sessions database table.
 * 
 */
@Entity
@Table(name="training_sessions")
@NamedQuery(name="TrainingSession.findAll", query="SELECT t FROM TrainingSession t")
public class TrainingSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRAINING_SESSIONID", unique=true, nullable=false)
	private int trainingSessionid;

	private float breather;

	private int reps;

	private float response;

	private int series;

	private float time;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="ACTIVITYID")
	private Activity activity;

	//bi-directional many-to-one association to Routine
	@ManyToOne
	@JoinColumn(name="ROUTINEID")
	private Routine routine;

	//bi-directional many-to-one association to Training
	@ManyToOne
	@JoinColumn(name="TRAININGID")
	private Training training;

	public TrainingSession() {
	}

	public int getTrainingSessionid() {
		return this.trainingSessionid;
	}

	public void setTrainingSessionid(int trainingSessionid) {
		this.trainingSessionid = trainingSessionid;
	}

	public float getBreather() {
		return this.breather;
	}

	public void setBreather(float breather) {
		this.breather = breather;
	}

	public int getReps() {
		return this.reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public float getResponse() {
		return this.response;
	}

	public void setResponse(float response) {
		this.response = response;
	}

	public int getSeries() {
		return this.series;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	public float getTime() {
		return this.time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public Activity getActivity() {
		return this.activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Routine getRoutine() {
		return this.routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

}