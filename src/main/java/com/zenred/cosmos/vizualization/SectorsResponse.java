package com.zenred.cosmos.vizualization;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("sectors")
public class SectorsResponse {
	
	private String sectors;

	public String getSectors() {
		return sectors;
	}

	public void setSectors(String sectors) {
		this.sectors = sectors;
	}

	@Override
	public String toString() {
		return "SectorsResponse [sectors=" + sectors + "]";
	}
	
	
	
	

}
