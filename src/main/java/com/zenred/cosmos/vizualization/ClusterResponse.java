package com.zenred.cosmos.vizualization;

import java.util.Arrays;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("stars")
public class ClusterResponse {
	
	private String [] stars;

	public String[] getStars() {
		return stars;
	}

	public void setStars(String[] stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "ClusterResponse [stars=" + Arrays.toString(stars) + "]";
	}
	
	

}
