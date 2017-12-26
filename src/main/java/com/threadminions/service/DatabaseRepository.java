package com.threadminions.service;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseRepository {
	
	@Autowired
	DataSource dataSource;
	
	/***
	 * If you are using DBCP connection pooling then use this method to get the connection details
	 */
	public void printDBCPConnectionDetails()
	{
		BasicDataSource basicDataSource = (BasicDataSource) dataSource;
		System.out.println("Instace of DBCP basic data source: " + basicDataSource);
		System.out.println("Driver class name: " + basicDataSource.getDriverClassName());
		System.out.println("Max idle connection: " + basicDataSource.getMaxIdle());
		System.out.println("Total connection: " + basicDataSource.getMaxTotal());
	}
	
	/***
	 * If using Hikari connection pooling
	 */
	/*public void printHikariConnectionDetails()
	{
		HikariDataSource ds = (HikariDataSource)dataSource;
		System.out.println("Instace of DBCP basic data source: " + ds);
		System.out.println("Driver class name: " + ds.getDriverClassName());
		System.out.println("Connection Pool size : " + ds.getMaximumPoolSize());
		System.out.println("Url: " + ds.getJdbcUrl());
		
	}*/

	/***
	 * If using C3P0 connection pooling
	 */
	/*public void printC3P0ConnectionDetails()
	{
		ComboPooledDataSource ds = (ComboPooledDataSource) dataSource;
		System.out.println("Instace of DBCP basic data source: " + ds);
		System.out.println("Connection Pool size : " + ds.getMaxPoolSize());
		System.out.println("Min connection pool size: " + ds.getMinPoolSize());
		System.out.println("Max statements: " + ds.getMaxStatements());
		System.out.println("Url: " + ds.getJdbcUrl());
	}*/
}
