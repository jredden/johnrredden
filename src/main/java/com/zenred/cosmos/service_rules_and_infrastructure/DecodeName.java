package com.zenred.cosmos.service_rules_and_infrastructure;

public class DecodeName {
	
	public interface UVcoordinate{
		Integer U = 0;
		Integer V = 0;
	}
	
	
	public static UVcoordinate nameToUV(String name){
		
		String [] splitName = name.split(".");
		UVcoordinate uVcoordinate = new UVcoordinate() {
		};

		for (int idex = 0; idex < splitName.length; idex++){
            if (Character.isDigit(splitName[idex].charAt(1))) {
            	String uString = "";
            	for(int idex2 = 0; idex2 < splitName[idex].length(); idex2++ ){
            		uString += splitName[idex].charAt(idex2);
            	}
            	
            }

			
		}
		return null;
	}

}
