package com.zenred.johntredden.vizualization;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("basicMesage")
public class BasicMessageResponse {
	
	private String theMessage;

	public String getTheMessage() {
		return theMessage;
	}

	public void setTheMessage(String theMessage) {
		this.theMessage = theMessage;
	}

	@Override
	public String toString() {
		return "BasicMessageResponse [theMessage=" + theMessage + "]";
	}
	
	

}
