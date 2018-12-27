/**
 * 
 */
package com.healthmetrics.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthmetrics.core.model.UsersRelation;

/**
 * @author Estevez
 *
 */
@Repository
public interface UsersRelationRepository extends JpaRepository<UsersRelation, Integer> {

}
