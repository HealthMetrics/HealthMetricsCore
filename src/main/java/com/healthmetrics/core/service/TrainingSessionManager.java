/**
 * 
 */
package com.healthmetrics.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthmetrics.core.dto.base.TrainingSessionDto;
import com.healthmetrics.core.exception.HealthMetricsException;

/**
 * @author Estevez
 *
 */
@Service
public interface TrainingSessionManager {

	public List<TrainingSessionDto> findAll() throws HealthMetricsException;

}
