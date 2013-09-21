package com.zenred.johntredden.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	
	private class StringRowMapperEmailAddress implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("emailAddress");
		}
	}
	
	private class StringRowMapperPassword implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("password");
		}
	}
	
	public User readUser(String firstName, String lastName, String password){
		User user = new User();
		String sql = "SELECT User FROM User WHERE lastName = ? AND firstName = ? AND password = ?";
		Map <String, Object> userMap = super.jdbcSetUp().getSimpleJdbcTemplate().queryForMap(sql, lastName, firstName, password);
		user.setUser_id(Integer.parseInt(userMap.get("User_id").toString()));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setEmailAddress(userMap.get("emailAddress").toString());
		return user;
	}
}
