package com.zenred.johntredden.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class QuestionDao extends AbstractJDBCDao {

	private static String tableNameGroup = "QuestionGroup";
	private static String tableNameQuestion = "Question";

	private class StringRowMapperQuestionGroupId implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("QuestionGroup_id");
		}
	}

	private class StringRowMapperQuestionGroupName implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("QuestionGroupName");
		}
	}

	private class StringQuestionId implements
			ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("Question_id");
		}
	}

	private class QuestionGroupId implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("QuestionGroup_id");
		}
	}
	
	private class QuestionContent implements ParameterizedRowMapper<String> {
		public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			return rs.getString("question_content");
		}
	}
	
	public Integer numberOfQuestions(){
		Integer answer = 0;
		String sql = "SELECT COUNT(*) FROM QuestionGroup";
		answer = super.jdbcSetUp().getSimpleJdbcTemplate().queryForInt(sql);
		return answer;
	}
}
