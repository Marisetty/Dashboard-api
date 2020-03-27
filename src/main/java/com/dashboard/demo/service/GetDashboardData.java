/**
 * 
 */
package com.dashboard.demo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 * @author maris
 *
 */
public interface GetDashboardData
{
	public ResponseEntity<Object> getDashboardData(Pageable page);

}
