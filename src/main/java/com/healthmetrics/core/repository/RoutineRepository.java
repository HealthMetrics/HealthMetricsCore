/**
 * 
 */
package com.healthmetrics.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmetrics.core.model.Routine;

/**
 * @author Estevez
 *
 */
@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {

}
