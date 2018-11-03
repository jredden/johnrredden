package com.zenred.cosmos.vizualization;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("createMessageResponse")
public class BasicMessageResponse {
	private String theMessage;

	public String getTheMessage() {
		return theMessage;
	}

	public void setTheMessage(String theMessage) {
		this.theMessage = theMessage;
	}


}
