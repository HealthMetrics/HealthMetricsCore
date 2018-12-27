/**
 * 
 */
package com.healthmetrics.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.healthmetrics.core.dto.base.TrainingSessionDto;
import com.healthmetrics.core.exception.HealthMetricsException;
import com.healthmetrics.core.mapper.user.TrainingSessionMapper;
import com.healthmetrics.core.model.TrainingSession;
import com.healthmetrics.core.repository.ActivityRepository;
import com.healthmetrics.core.repository.RoutineRepository;
import com.healthmetrics.core.repository.TrainingRepository;
import com.healthmetrics.core.repository.TrainingSessionRepository;
import com.healthmetrics.core.service.TrainingSessionManager;

/**
 * @author Estevez
 *
 */
@Service
@Qualifier("trainingSessionManager")
public class TrainingSessionManagerImpl implements TrainingSessionManager {
	
	@Autowired
	private TrainingSessionRepository trainingSessionRepository;
	
	@Autowired
	private RoutineRepository routineRepository;
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private ActivityRepository activityRepository;

	/**
	 * 
	 */
	public TrainingSessionManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public List<TrainingSessionDto> findAll() throws HealthMetricsException {
		List<TrainingSession> allTrainingSessions = trainingSessionRepository.findAll();
		return TrainingSessionMapper.trainingSessionListToTrainingSessionDtoList(allTrainingSessions);
		//return UserMapper.userListToUserDtoList(allUsers);
	}

}
