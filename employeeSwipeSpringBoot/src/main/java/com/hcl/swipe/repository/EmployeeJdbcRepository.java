package com.hcl.swipe.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hcl.swipe.model.Employee;

@Repository
public class EmployeeJdbcRepository implements EmployeeRepo{

	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 
	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("select * from employees", new EmployeeRowMapper());
	}

	@Override
	public int save(Employee employee) {
		return jdbcTemplate.update("insert into employees (id, name, locationName, designation,"
				+ "date,swipeIn,swipeOut,status) " + "values(?, ?, ?, ?,?,?,?,?)",
	            new Object[] {
	                employee.getId(), employee.getName(), employee.getLocationName(), employee.getDesignation(),
	                employee.getDate(), employee.getSwipeIn(), employee.getSwipeOut(), employee.getStatus()
	            });
	}

	@Override
	public int update(Employee employee) {
		 return jdbcTemplate.update("update employees " + " set locationName = ?,swipeOut = ?, status = ?  " + " where id = ?",
		            new Object[] {
		                employee.getLocationName(),  employee.getSwipeOut(),employee.getStatus(), employee.getId()
		            });
	}
	
	 class EmployeeRowMapper implements RowMapper < Employee > {
	        @Override
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee employee = new Employee();
	            employee.setId(rs.getLong("id"));
	            employee.setName(rs.getString("name"));
	            employee.setLocationName(rs.getString("locationName"));
	            employee.setDate((Date)rs.getDate("date"));
	            employee.setSwipeIn((Date)rs.getDate("swipeIn"));
	            employee.setSwipeOut((Date)rs.getDate("swipeOut"));
	            employee.setStatus(rs.getString("status"));
	            return employee;
	        }
	    }

}
