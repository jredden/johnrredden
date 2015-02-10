package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

import com.zenred.cosmos.domain.ClusterRep;

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
	
	private static Map<Object, PlanetoidDomainFactory> classMap = new HashMap<Object, PlanetoidDomainFactory>();
	static{
		classMap.put(ClusterRep.class, CLUSTER);
		classMap.put(Star.class, STAR);
		classMap.put(Planetoid.class, PLANETOID);
	}
	public static String planetoidDomain(Class clazz){
		return classMap.get(clazz).type;
	}
}
