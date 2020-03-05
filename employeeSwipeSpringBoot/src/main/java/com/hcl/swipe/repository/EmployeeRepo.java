package com.hcl.swipe.repository;

import java.util.List;

import com.hcl.swipe.model.Employee;

public interface EmployeeRepo 
 {
	/*
	 * List<Employee> findByName(String name); List<Employee> findByDate(String
	 * startDate,String endDate); List<Employee> findById(String Id); List<Employee>
	 * findByLocationName(String locationName);
	 */
	    List<Employee> findAll();
	    int save(Employee employee);
	    int update(Employee employee);

	    
}
