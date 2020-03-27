/**
 * 
 */
package com.dashboard.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.demo.constants.DashboardConstants;
import com.dashboard.demo.service.GetDashboardData;
import com.dashboard.demo.service.InsertDashboardDataService;

/**
 * @author Marisetty
 *
 */
@RestController
public class DashboardController
{
	@Autowired
	private GetDashboardData getDashboardData;
	
	@Autowired
	private InsertDashboardDataService insertDashboardDataService;
	
	@GetMapping(value=DashboardConstants.GET_DASHBOARD_DATA)
	public ResponseEntity<Object> getDashboardData(Pageable page)
	{
		return getDashboardData.getDashboardData(page);
	}
	
	@GetMapping(value = DashboardConstants.INSERT_DASHBOARD_DATA)
	public void insertInBothTables(@RequestParam int records)
	{
		insertDashboardDataService.insertDashboardDataService(records);
	}

	
}
