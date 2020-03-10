package com.hcl.swipe.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.swipe.exception.EmployeeNotFoundException;
import com.hcl.swipe.model.Employee;
import com.hcl.swipe.repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepo repo; 
	
	@Override
	public List<Employee> fetchEmployees() throws EmployeeNotFoundException {
		List<Employee> list = new ArrayList<Employee>();
		list = repo.findAll();
		if (list == null || list.isEmpty()) {
			throw new EmployeeNotFoundException("Employee Not found ");
		}
		return repo.findAll();

	}

	@Override
	public int saveEmployee(Employee employee) {
		return repo.save(employee);
	}

	@Override
	public int updateEmployee(Employee employee) throws EmployeeNotFoundException {
		int value = repo.update(employee);
		if (value != 1) {
			throw new EmployeeNotFoundException("Update Failed");
		}
		return repo.update(employee);
	}

}
