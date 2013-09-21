package com.zenred.johntredden.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class UserDao extends AbstractJDBCDao {
	private class StringRowMapperUserId implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("User_id");
		}
	}

	private class StringRowMapperUserStatus implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("User_status");
		}
	}

	private class StringRowMapperFirstName implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("firstName");
		}
	}
	
	private class StringRowMapperLastName implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("lastName");
		}
	}
}
