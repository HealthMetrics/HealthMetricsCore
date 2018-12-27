/**
 * 
 */
package com.healthmetrics.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmetrics.core.model.Training;

/**
 * @author Estevez
 *
 */
@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {

}
