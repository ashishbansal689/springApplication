package com.threadminions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.threadminions.model.Employee;

@Component
public class EmployeeServiceLayer {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Scheduled(fixedRate = 5000)
	public void printEmployees()
	{
		List<Employee> allEmps = jdbcTemplate.query("select * from employee", new Extractor());
		
		allEmps.forEach(emp -> 
		{
			System.out.println("Employee Name: " + emp.getEmployeeName());
			System.out.println("Employee Salary: " + emp.getEmployeeSalary());
		});
	}
}
