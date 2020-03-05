package com.hcl.swipe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.swipe.model.Employee;
import com.hcl.swipe.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo repo; 
	
	@Override
	public List<Employee> fetchEmployees() {
		return repo.findAll();
	}

	@Override
	public int saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		return repo.update(employee);
	}

}
