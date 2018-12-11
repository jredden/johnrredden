package com.zenred.cosmos.service_rules_and_infrastructure;

public class DecodeName {
	
	public interface UVcoordinate{
		
		void setU(Integer u);
		Integer getU();
		void setV(Integer v);
		Integer getV();
	}
	
	
	public static UVcoordinate nameToUV(String name){
		
		String [] splitName = name.split("\\.");
		UVcoordinate uVcoordinate = new UVcoordinate() {
			Integer U = 0;
			Integer V = 0;

			@Override
			public void setU(Integer u) {
				U = u;
			}

			@Override
			public Integer getU() {
				return U;
			}

			@Override
			public void setV(Integer v) {
				V = v;
				
			}

			@Override
			public Integer getV() {
				return V;
			}
		};
		Integer numberDecoded = 0;
		for (int idex = 0; idex < splitName.length; idex++){
            if (Character.isDigit(splitName[idex].charAt(0))) {
            	String uString = "";
            	for(int idex2 = 0; idex2 < splitName[idex].length(); idex2++ ){
            		uString += splitName[idex].charAt(idex2);
            	}
            	uVcoordinate.setU(new Integer(uString));
            	numberDecoded += 1;
            	++idex;
            }

            
            
            if (Character.isDigit(splitName[idex].charAt(0))) {
            	String vString = "";
            	for(int idex2 = 0; idex2 < splitName[idex].length(); idex2++ ){
            		vString += splitName[idex].charAt(idex2);
            	}
            	uVcoordinate.setV(new Integer(vString));
            	numberDecoded += 1;
            }
			if (numberDecoded == 2){
				break;
			}
		}
		return uVcoordinate;
	}

}
