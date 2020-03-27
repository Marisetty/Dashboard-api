package com.dashboard.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dashboard.demo.model.DashboardDetails;
import com.dashboard.demo.model.Status_Statistics;
import com.dashboard.demo.repository.DashboardRepository;
import com.dashboard.demo.repository.StatusStatisticsRepository;

@Service
public class InsertDashboardDataServiceImpl implements InsertDashboardDataService 
{
	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	private StatusStatisticsRepository statusRepository;
	
	@Override
	public void insertDashboardDataService(int noOfRecords)
	{
		for(int i = 0; i < noOfRecords; i++)
		{
			DashboardDetails dashboard = new DashboardDetails();

			dashboard.setFileId(String.valueOf(i));
			dashboard.setFileName("FileName-"+ String.valueOf(i));
			dashboard.setFileImportedDate("3/27/2020");
			
			dashboardRepository.save(dashboard);
			
			Status_Statistics status = new Status_Statistics();
			status.setCustomerId("customerId-"+i);
			status.setCustomerName("customerName-"+i);
			status.setFileId(String.valueOf(i));
			status.setFileReceivedData("03/27/2020");
			status.setSubmitterId("submitterId-"+i);
			status.setSubscriberId("subscriberId-"+i);
			
			statusRepository.save(status);
		}
	}
}
