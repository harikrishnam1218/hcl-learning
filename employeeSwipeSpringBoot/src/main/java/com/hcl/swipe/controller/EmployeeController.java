package com.hcl.swipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.swipe.model.Employee;
import com.hcl.swipe.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/list")
	public List<Employee> employeDetails() {
		List<Employee> list=employeeService.fetchEmployees();
		//return new ResponseEntity(list, HttpStatus.OK);
		return list;
	}
	@PostMapping(value="/save")
	public int saveEmployee(@RequestBody Employee employee){
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping(value="/update")
	public int updateEmployee(@RequestBody Employee employee){
		return employeeService.updateEmployee(employee);
	}
	
}
