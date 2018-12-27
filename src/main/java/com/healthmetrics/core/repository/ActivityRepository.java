/**
 * 
 */
package com.healthmetrics.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmetrics.core.model.Activity;

/**
 * @author Estevez
 *
 */
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
