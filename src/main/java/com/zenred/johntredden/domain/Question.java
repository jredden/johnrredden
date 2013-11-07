package com.zenred.johntredden.domain;

public class Question {

	private int question_id;
	private int questionGroupId;
	private String questionContent;
	
	public int getQuestion_id() {
		return question_id;
	}
	public int getQuestionGroupId() {
		return questionGroupId;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public void setQuestionGroup(int questionGroupId) {
		this.questionGroupId = questionGroupId;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	
	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", questionGroup="
				+ questionGroupId + ", questionContent=" + questionContent + "]";
	}
	
	
}
