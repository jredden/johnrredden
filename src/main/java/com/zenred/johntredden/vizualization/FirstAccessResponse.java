package com.zenred.johntredden.vizualization;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("firstAccessResponse")
public class FirstAccessResponse {
	private List<String> questionList;
	private String key;
	private Integer questionNumber;

	public List<String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	@Override
	public String toString() {
		return "FirstAccessResponse [questionList=" + questionList + ", key="
				+ key + ", questionNumber=" + questionNumber + "]";
	}
	
	
}
