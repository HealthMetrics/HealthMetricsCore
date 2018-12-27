/**
 * 
 */
package com.healthmetrics.core.mapper.user;

import java.util.ArrayList;
import java.util.List;

import com.healthmetrics.core.dto.base.TrainingSessionDto;
import com.healthmetrics.core.model.TrainingSession;

/**
 * @author Estevez
 *
 */
public abstract class TrainingSessionMapper {

	/**
	 * 
	 */
	public TrainingSessionMapper() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Converts a JPA User object to a DTO (does not convert the password!).
	 * 
	 * @param user
	 *            JPA User.
	 * 
	 * @return User DTO.
	 */
	public static TrainingSessionDto trainingSessionToTrainingSessionDto(TrainingSession trainingSession) {

		return new TrainingSessionDto(trainingSession.getTrainingSessionid(), 0, trainingSession.getTraining().getTrainingid(), trainingSession.getActivity().getActivityid(), trainingSession.getSeries(), trainingSession.getReps(), trainingSession.getTime(), trainingSession.getBreather(), trainingSession.getResponse());
	}
	 
	/**
	 * Converts a list of JPA User objects to a list of DTOs.
	 * 
	 * @param users
	 *            List of JPA Users.
	 * 
	 * @return List of DTOs.
	 */
	public static List<TrainingSessionDto> trainingSessionListToTrainingSessionDtoList(List<TrainingSession> trainingSessions) {
		List<TrainingSessionDto> list = new ArrayList<TrainingSessionDto>(trainingSessions.size());

		for (TrainingSession trainingSession : trainingSessions) {
			list.add(trainingSessionToTrainingSessionDto(trainingSession));
		}

		return list;
	}

}
