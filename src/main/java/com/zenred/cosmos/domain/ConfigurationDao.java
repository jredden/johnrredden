package com.zenred.cosmos.domain;

import java.util.Map;

import com.zenred.johntredden.domain.AbstractJDBCDao;

public class ConfigurationDao extends AbstractJDBCDao {
	
	private static String CONFIGURATION = "Configuration";
	private static String STAR_DENSITY = "starDensity";
	
	private static String readStarDensity = "SELECT "
			+ " " + STAR_DENSITY + " "
			+ " FROM " + CONFIGURATION
	;
	
	/**
	 * 
	 * @return star density
	 */
	public Double starDensity(){
		Double density = super.jdbcSetUp().getSimpleJdbcTemplate().queryForObject(readStarDensity, Double.class);
		return density;
	}
}
