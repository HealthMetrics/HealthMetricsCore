package com.healthmetrics.core.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the routines_trainings database table.
 * 
 */
@Entity
@Table(name="routines_trainings")
@NamedQuery(name="RoutinesTraining.findAll", query="SELECT r FROM RoutinesTraining r")
public class RoutinesTraining implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ROUTINE_TRAININGID", unique=true, nullable=false)
	private int routineTrainingid;

	private float breather;

	private float reps;

	private int series;

	private float time;

	//bi-directional many-to-one association to Activity
	@ManyToOne
	@JoinColumn(name="ACTIVITYID", nullable=false)
	private Activity activity;

	//bi-directional many-to-one association to Routine
	@ManyToOne
	@JoinColumn(name="ROUTINEID", nullable=false)
	private Routine routine;

	public RoutinesTraining() {
	}

	public int getRoutineTrainingid() {
		return this.routineTrainingid;
	}

	public void setRoutineTrainingid(int routineTrainingid) {
		this.routineTrainingid = routineTrainingid;
	}

	public float getBreather() {
		return this.breather;
	}

	public void setBreather(float breather) {
		this.breather = breather;
	}

	public float getReps() {
		return this.reps;
	}

	public void setReps(float reps) {
		this.reps = reps;
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

}