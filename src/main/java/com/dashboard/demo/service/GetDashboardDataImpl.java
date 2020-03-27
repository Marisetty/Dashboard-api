/**
 * 
 */
package com.dashboard.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dashboard.demo.constants.DashboardConstants;
import com.dashboard.demo.model.DashboardDetails;
import com.dashboard.demo.model.Status_Statistics;
import com.dashboard.demo.repository.DashboardRepository;
import com.dashboard.demo.repository.StatusStatisticsRepository;

/**
 * @author maris
 *
 */
@Service
public class GetDashboardDataImpl implements GetDashboardData {
	
	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	private StatusStatisticsRepository statsRepository;
	
	
    @Autowired private MongoOperations mongoOps;

	public ResponseEntity<Object> getDashboardData(Pageable pageable)
	{
		int pageSize = pageable.getPageSize();
		int pageNumber = pageable.getPageNumber();
		//Sort sort = pageable.getSort(); 
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		long startTime = System.currentTimeMillis();
		
		Page<DashboardDetails> dashboardDetails = dashboardRepository.findAll(page);
		
		List<DashboardDetails> dashboardDetailsResponse = dashboardDetails.getContent();
		
		List<Status_Statistics> statsStatistics = new ArrayList<>();
		if(dashboardDetailsResponse != null && !dashboardDetailsResponse.isEmpty())
		{
			List<String> fileIds = getFileIds(dashboardDetailsResponse);
			Query query = new Query(Criteria.where("fileId").in(fileIds));
			
	        statsStatistics = mongoOps.find(query, Status_Statistics.class);
	        
	        System.out.println(statsStatistics.size());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken for - " + (endTime - startTime) + "-ms");

		//System.out.println("Dashboard Content - " + dashboardDetailsResponse);
		
/*		long startTime1= System.currentTimeMillis();
		Page<Status_Statistics> statusStats = statsRepository.findAll(page);
		//System.out.println(statusStats);
		long endTime1 = System.currentTimeMillis();
		
		System.out.println("Time Taken for Fetching statusStats Details from Page - " + pageNumber + " in Time - " + (endTime1 - startTime1) + "-ms");
		
		List<Object> finalList = new ArrayList<Object>();
		finalList.add(dashboardDetailsResponse);
		//finalList.add(statusStats);
		
		// we Need to do the data cleanup to get the details from fileDetails collection's data
*/
		return new ResponseEntity<Object>(statsStatistics, HttpStatus.OK);
	}

	private List<String> getFileIds(List<DashboardDetails> dashboardDetailsResponse)
	{
		List<String> fileIds = new ArrayList<>();
		for(DashboardDetails dashboardDetails : dashboardDetailsResponse)
		{
			if(dashboardDetails.getFileId() != null && !dashboardDetails.getFileId().equalsIgnoreCase(DashboardConstants.EMPTY))
			{
				fileIds.add(dashboardDetails.getFileId());
			}
		}
		return fileIds;
	}
}
