package com.zenred.johntredden.domain;

import java.util.Properties;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.apache.log4j.Logger;

public abstract class AbstractJDBCDao {
	static private Logger logger = Logger.getLogger(AbstractJDBCDao.class);
	
	static private DriverManagerDataSource driverManagerDataSource = null;
	private static void fetchDataSource(){
		if(null == driverManagerDataSource){
			driverManagerDataSource= new DriverManagerDataSource();
			logger.info("driverManagerDataSource estblished");
		}

	}
	
	public static SimpleJdbcDaoSupport jdbcSetUp() {
		fetchDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

		driverManagerDataSource
				.setUrl("jdbc:mysql://localhost/johntredden");
		driverManagerDataSource.setUsername("jredden");
		driverManagerDataSource
				.setPassword("nCXL3O2GVAwLBJnT");

		Properties connectionProperties = new Properties();
		connectionProperties.setProperty("noAccessToProcedureBodies", "true"); // *sigh*.
																				// to
																				// allow
																				// sp's
																				// to
																				// run
		driverManagerDataSource.setConnectionProperties(connectionProperties);
		SimpleJdbcDaoSupport simpleJdbcDaoSupport = new SimpleJdbcDaoSupport();
		simpleJdbcDaoSupport.setDataSource(driverManagerDataSource);
		return simpleJdbcDaoSupport;
	}

	public static SimpleJdbcInsert jdbcInsertSetup() {
		fetchDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

		driverManagerDataSource
				.setUrl("jdbc:mysql://localhost/johntredden");
		driverManagerDataSource.setUsername("jredden");
		driverManagerDataSource
				.setPassword("nCXL3O2GVAwLBJnT");
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(
				driverManagerDataSource);
		return simpleJdbcInsert;
	}

}
