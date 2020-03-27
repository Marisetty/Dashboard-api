package com.dashboard.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dashboard.demo.model.Status_Statistics;

@Repository
public interface StatusStatisticsRepository extends MongoRepository<Status_Statistics, String> {

}
