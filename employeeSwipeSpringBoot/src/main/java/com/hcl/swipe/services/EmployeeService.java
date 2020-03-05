package com.hcl.swipe.services;

import java.util.List;

import com.hcl.swipe.model.Employee;

public interface EmployeeService {
 
	List<Employee> fetchEmployees();
	int saveEmployee(Employee employee);
	int updateEmployee(Employee employee);
	
}
