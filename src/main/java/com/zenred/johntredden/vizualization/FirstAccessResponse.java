package com.zenred.johntredden.vizualization;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("firstAccessResponse")
public class FirstAccessResponse {
	private List<String> questionList;

	public List<String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<String> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "FirstAccessResponse [questionList=" + questionList + "]";
	}
	
	
}
