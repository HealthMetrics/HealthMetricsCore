/**
 * 
 */
package com.healthmetrics.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmetrics.core.model.RoutinesTraining;

/**
 * @author Estevez
 *
 */
@Repository
public interface RoutinesTrainingRepository extends JpaRepository<RoutinesTraining, Integer> {

}
