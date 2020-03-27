/**
 * 
 */
package com.dashboard.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.demo.model.DashboardDetails;

/**
 * @author maris
 *
 */
@Repository
public interface DashboardRepository extends MongoRepository<DashboardDetails, String> {
}
