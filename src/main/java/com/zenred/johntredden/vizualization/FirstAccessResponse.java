package com.zenred.johntredden.vizualization;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("firstAccessResponse")
public class FirstAccessResponse {
	private List<String> questionList;
	private Integer questionNumber;
	private String secondQuestion;

	public List<String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public String getSecondQuestion() {
		return secondQuestion;
	}

	public void setSecondQuestion(String secondQuestion) {
		this.secondQuestion = secondQuestion;
	}

	@Override
	public String toString() {
		return "FirstAccessResponse [questionList=" + questionList
				+ ", questionNumber=" + questionNumber + ", secondQuestion="
				+ secondQuestion + "]";
	}
	
	
}
