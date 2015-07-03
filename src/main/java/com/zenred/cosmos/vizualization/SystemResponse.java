package com.zenred.cosmos.vizualization;

import java.util.Arrays;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("systems")
public class SystemResponse {
	
	// An array of visualization centric star systems.
	
	private SystemVizCentric [] systemVizCentrics;

	public SystemVizCentric[] getSystemVizCentrics() {
		return systemVizCentrics;
	}

	public void setSystemVizCentrics(SystemVizCentric[] systemVizCentrics) {
		this.systemVizCentrics = systemVizCentrics;
	}

	@Override
	public String toString() {
		return "SystemResponse [systemVizCentrics="
				+ Arrays.toString(systemVizCentrics) + "]";
	}
	
	

}
