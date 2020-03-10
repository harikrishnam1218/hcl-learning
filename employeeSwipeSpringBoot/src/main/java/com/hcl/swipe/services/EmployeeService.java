package com.hcl.swipe.services;

import java.util.List;

import com.hcl.swipe.exception.EmployeeNotFoundException;
import com.hcl.swipe.model.Employee;

public interface EmployeeService {
 
	List<Employee> fetchEmployees() throws EmployeeNotFoundException;
	int saveEmployee(Employee employee);
	int updateEmployee(Employee employee) throws EmployeeNotFoundException;
	
}
