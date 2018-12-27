/**
 * 
 */
package com.healthmetrics.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthmetrics.core.model.TrainingSession;

/**
 * @author Estevez
 *
 */
public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Integer> {

}
