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
	
	public static Map<String, PlanetoidDomainFactory> databaseMap = new HashMap<String, PlanetoidDomainFactory>();
	static{
		databaseMap.put("cluster", CLUSTER);
		databaseMap.put("star", STAR);
		databaseMap.put("planetoid", PLANETOID);
	}
}
