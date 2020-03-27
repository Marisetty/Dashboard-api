/**
 * 
 */
package com.dashboard.demo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author maris
 *
 */
@Service
public class GetDashboardDataImpl implements GetDashboardData {

	/* (non-Javadoc)
	 * @see com.dashboard.demo.controller.GetDashboardData#getDashboardData(org.springframework.data.domain.Pageable)
	 */
	@Override
	public ResponseEntity<Object> getDashboardData(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
