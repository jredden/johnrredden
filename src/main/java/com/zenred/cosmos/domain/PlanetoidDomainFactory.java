package com.zenred.cosmos.domain;

public enum PlanetoidDomainFactory {
	CLUSTER("cluster"){
		
	},
	STAR("star"){
		
	},
	PLANETOID("planetoid"){
		
	}
	;
	
	private String type;
	
	private PlanetoidDomainFactory (String type){
		this.type = type;
	}
}
