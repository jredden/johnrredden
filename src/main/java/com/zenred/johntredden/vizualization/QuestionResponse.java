package com.zenred.johntredden.vizualization;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("basicMesage")
public class QuestionResponse {
	
	private String theMessage;
	private String secondQuestion;

	public String getTheMessage() {
		return theMessage;
	}

	public void setTheMessage(String theMessage) {
		this.theMessage = theMessage;
	}

	public String getSecondQuestion() {
		return secondQuestion;
	}

	public void setSecondQuestion(String secondQuestion) {
		this.secondQuestion = secondQuestion;
	}

	@Override
	public String toString() {
		return "QuestionResponse [theMessage=" + theMessage
				+ ", secondQuestion=" + secondQuestion + "]";
	}
	
	

}
