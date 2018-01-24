package com.threadminions;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.threadminions.model.ConfigProperty;
import com.threadminions.service.EmployeeServiceLayer;

@SpringBootApplication(exclude = { DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class })
public class SpringBootConfig implements CommandLineRunner 
{
	@Autowired
	EmployeeServiceLayer employeeService;

	@Bean(destroyMethod = "")
	public DataSource dataSource(ConfigProperty configProperty) 
	{
		String url = "";
		String password = configProperty.getPassword();
		String dbType = configProperty.getDbType();
		String driverClassName = "";
		if ("mysql".equalsIgnoreCase(dbType)) {
			driverClassName = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://" + configProperty.getDbIp() + ":" + configProperty.getDbPort() + "/"
					+ configProperty.getDbName();
		}

		else if ("oracle".equalsIgnoreCase(dbType)) {
			driverClassName = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@" + configProperty.getDbIp() + ":" + configProperty.getDbPort() + ":"
					+ configProperty.getDbName();
		}

		return DataSourceBuilder.create().driverClassName(driverClassName).url(url).username("root").password(password)
				.type(BasicDataSource.class).build();
	}

	public static void main(String[] ar) {
		SpringApplication.run(SpringBootConfig.class, ar);
	}

	@Override
	public void run(String... arg0) throws Exception {
		employeeService.printEmployees();
	}
}
