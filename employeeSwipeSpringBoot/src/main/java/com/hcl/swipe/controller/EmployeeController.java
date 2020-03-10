package com.hcl.swipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.swipe.exception.EmployeeNotFoundException;
import com.hcl.swipe.model.Employee;
import com.hcl.swipe.services.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/list")
	public ResponseEntity<List<Employee>> employeDetails() throws EmployeeNotFoundException {
		List<Employee> list=employeeService.fetchEmployees();
		return new ResponseEntity(list, HttpStatus.OK);
		//return list;
	}
	@PostMapping(value="/save")
	public ResponseEntity saveEmployee(@Valid @RequestBody Employee employee){
		return new ResponseEntity(employeeService.saveEmployee(employee),HttpStatus.OK);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException{
		return new ResponseEntity(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	
}
