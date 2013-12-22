package com.zenred.johntredden.vizualization;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("basicMesage")
public class BasicMessageResponse {
	
	private String theMessage;
	private List<String> questionList;
	private Integer questionNumber;
	private String secondQuestion;


	public String getTheMessage() {
		return theMessage;
	}

	public void setTheMessage(String theMessage) {
		this.theMessage = theMessage;
	}

	public List<String> getQuestionList() {
		return questionList;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public String getSecondQuestion() {
		return secondQuestion;
	}

	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public void setSecondQuestion(String secondQuestion) {
		this.secondQuestion = secondQuestion;
	}

	@Override
	public String toString() {
		return "BasicMessageResponse [theMessage=" + theMessage
				+ ", questionList=" + questionList + ", questionNumber="
				+ questionNumber + ", secondQuestion=" + secondQuestion + "]";
	}
	
	

}
