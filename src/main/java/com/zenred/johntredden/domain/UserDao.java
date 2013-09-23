package com.zenred.johntredden.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 * 
 * @author jredden
 * 
 *         Easy Spring JDBC mapping of database User entity and User domain
 *         object
 * 
 *         Basic C.R.U.D. pattern plus some ...
 * 
 */

public class UserDao extends AbstractJDBCDao {

	private static String tableName = "User";

	private class StringRowMapperUserId implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("User_id");
		}
	}

	private class StringRowMapperUserStatus implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("User_status");
		}
	}

	private class StringRowMapperFirstName implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("firstName");
		}
	}

	private class StringRowMapperLastName implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("lastName");
		}
	}

	private class StringRowMapperEmailAddress implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("emailAddress");
		}
	}

	private class StringRowMapperPassword implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("password");
		}
	}

	public User readUser(String firstName, String lastName, String password) {
		User user = new User();
		String sql = "SELECT User_id, emailAddress, User_status FROM User WHERE lastName = ? AND firstName = ? AND password = ?";
		Map<String, Object> userMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(sql, lastName, firstName, password);
		user.setUser_id(Integer.parseInt(userMap.get("User_id").toString()));
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setEmailAddress(userMap.get("emailAddress").toString());
		user.setUser_Status(UserStatus.whichStatus(userMap.get("User_status")
				.toString()));
		return user;
	}

	public User readUser(String emailAddress, String password) {
		User user = new User();
		String sql = "SELECT User_id, firstName, lastName, User_status FROM User WHERE emailAddress = ? AND password = ?";
		Map<String, Object> parameters = new HashMap<String, Object>();
		Object[] param = { emailAddress, password };
		Map<String, Object> userMap = super.jdbcSetUp().getSimpleJdbcTemplate()
				.queryForMap(sql, param);
		user.setUser_id(Integer.parseInt(userMap.get("User_id").toString()));
		user.setFirstName(userMap.get("firstName").toString());
		user.setLastName(userMap.get("lastName").toString());
		user.setUser_Status(UserStatus.whichStatus(userMap.get("User_status")
				.toString()));
		user.setPassword(password);
		user.setEmailAddress(emailAddress);
		return user;
	}

	public void createUser(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firstName", user.getFirstName());
		map.put("lastName", user.getLastName());
		map.put("password", user.getPassword());
		map.put("emailAddress", user.getEmailAddress());
		map.put("User_status", user.getUser_Status().name());
		super.jdbcInsertSetup()
				.withTableName(tableName)
				.usingColumns("firstName", "lastName", "password",
						"emailAddress", "User_status").execute(map);
	}

	public void updateUserStatusToCandidate2(String tempPassword) {
		String sql = "UPDATE User SET User_status = 'candidate2' WHERE password = ?";
		super.jdbcSetUp().getSimpleJdbcTemplate()
				.update(sql, new Object[] { tempPassword });
	}

	public void updateUserAsRegistered(String tempPassword, User user) {
		String sql = "UPDATE User SET User_status = ?, firstName = ?, lastName = ?, password = ?, emailAddress = ? WHERE password = ?";

		user.setUser_Status(UserStatus.registered);
		super.jdbcSetUp()
				.getSimpleJdbcTemplate()
				.update(sql,
						new Object[] { user.getUser_Status().name(),
								user.getFirstName(), user.getLastName(),
								user.getPassword(), user.getEmailAddress(),
								tempPassword });

	}

	public void deleteUser(String password) {
		String sql = "DELETE FROM User  WHERE password = ?";
		super.jdbcSetUp().getSimpleJdbcTemplate()
				.update(sql, new Object[] { password });
	}
}
