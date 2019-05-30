package com.zenred.cosmos.vizualization;

import java.util.Arrays;
import java.util.List;

public class NamedSystemVizCentric extends SystemVizCentric {
	private String [] renames;
	
	public String [] getRenams(){
		return renames;
	}
	
	public void setRenames(List<String> l_renames){
		Object [] o_renames = l_renames.toArray();
		renames = new String[l_renames.size()];
		for (int idex =0; idex < l_renames.size(); idex++){
			renames[idex] = o_renames[idex].toString();
		}
	}

	@Override
	public String toString() {
		return "NamedSystemVizCentric [renames=" + Arrays.toString(renames) + "]";
	}
	
	
}
