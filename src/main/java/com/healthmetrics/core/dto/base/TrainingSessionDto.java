package com.healthmetrics.core.dto.base;

public class TrainingSessionDto {
	
	private Integer trainingSessionID;
	private Integer routineID;
	private Integer trainingID;
	private Integer activityID;
	private Integer series;
	private Integer reps;
	private float time;
	private float breather;
	private float response;

	public TrainingSessionDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param trainingSessionID
	 * @param routineID
	 * @param trainingID
	 * @param activityID
	 * @param series
	 * @param reps
	 * @param time
	 * @param breather
	 * @param response
	 */
	public TrainingSessionDto(Integer trainingSessionID, Integer routineID, Integer trainingID, Integer activityID,
			Integer series, Integer reps, float time, float breather, float response) {
		super();
		this.trainingSessionID = trainingSessionID;
		this.routineID = routineID;
		this.trainingID = trainingID;
		this.activityID = activityID;
		this.series = series;
		this.reps = reps;
		this.time = time;
		this.breather = breather;
		this.response = response;
	}

	/**
	 * @return the trainingSessionID
	 */
	public Integer getTrainingSessionID() {
		return trainingSessionID;
	}

	/**
	 * @param trainingSessionID the trainingSessionID to set
	 */
	public void setTrainingSessionID(Integer trainingSessionID) {
		this.trainingSessionID = trainingSessionID;
	}

	/**
	 * @return the routineID
	 */
	public Integer getRoutineID() {
		return routineID;
	}

	/**
	 * @param routineID the routineID to set
	 */
	public void setRoutineID(Integer routineID) {
		this.routineID = routineID;
	}

	/**
	 * @return the trainingID
	 */
	public Integer getTrainingID() {
		return trainingID;
	}

	/**
	 * @param trainingID the trainingID to set
	 */
	public void setTrainingID(Integer trainingID) {
		this.trainingID = trainingID;
	}

	/**
	 * @return the activityID
	 */
	public Integer getActivityID() {
		return activityID;
	}

	/**
	 * @param activityID the activityID to set
	 */
	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}

	/**
	 * @return the series
	 */
	public Integer getSeries() {
		return series;
	}

	/**
	 * @param series the series to set
	 */
	public void setSeries(Integer series) {
		this.series = series;
	}

	/**
	 * @return the reps
	 */
	public Integer getReps() {
		return reps;
	}

	/**
	 * @param reps the reps to set
	 */
	public void setReps(Integer reps) {
		this.reps = reps;
	}

	/**
	 * @return the time
	 */
	public float getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(float time) {
		this.time = time;
	}

	/**
	 * @return the breather
	 */
	public float getBreather() {
		return breather;
	}

	/**
	 * @param breather the breather to set
	 */
	public void setBreather(float breather) {
		this.breather = breather;
	}

	/**
	 * @return the response
	 */
	public float getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(float response) {
		this.response = response;
	}
	
	

}
