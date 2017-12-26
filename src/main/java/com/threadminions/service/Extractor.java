package com.threadminions.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.threadminions.model.Employee;

public class Extractor implements RowMapper<Employee> 
{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException 
	{
		Employee emp = new Employee();
		emp.setEmpId(rs.getInt("emp_id"));
		emp.setEmployeeName(rs.getString("employee_name"));
		emp.setEmployeeDesignation(rs.getString("employee_designation"));
		emp.setEmployeeSalary(rs.getInt("employee_salary"));
		
		return emp;
	}

}
