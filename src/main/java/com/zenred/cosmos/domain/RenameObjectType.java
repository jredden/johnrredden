package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;

interface ObjectName{
	String objectName();
}

interface ObjectList{
	List<Object> objectList();
}

class ObjectNameImpl{
	protected static ObjectName planetoidName = new ObjectName(){
		public String objectName(){
			return "PLANETOID";
		}
	};
	protected static ObjectName starName = new ObjectName(){
		public String objectName(){
			return "STAR";
		}
	};	protected static ObjectName clusterName = new ObjectName(){
		public String objectName(){
			return "CLUSTER";
		}
	};
}




public enum RenameObjectType {
		
		PLANETOID("PLANETOID"){

			@Override
			ObjectName getName() {
				return ObjectNameImpl.planetoidName;
			}

			@Override
			ObjectList getObjectList() {
				PlanetoidDao planetoidDao = new PlanetoidDao();
				List<Object> genericList = new ArrayList<>();
				List<Planetoid> allPlanetoids = new ArrayList<Planetoid>();
				allPlanetoids = planetoidDao.readAllPlanetoids();
				for (Planetoid aPlanetoid : allPlanetoids) {
					Object object = (Object)aPlanetoid;
					genericList.add(object);
				}
				
				return (ObjectList) genericList;
			}
			
				
			
		},
		STAR("STAR"){

			@Override
			ObjectName getName() {
				return ObjectNameImpl.starName;
			}

			@Override
			ObjectList getObjectList() {
				StarDao starDao = new StarDao();
				List<Object> genericList = new ArrayList<>();
				List<Star> allStars = new ArrayList<Star>();
				for (Star aStar : allStars){
					Object object = (Object) aStar;
					genericList.add(object);
				}
				return (ObjectList) genericList;
			}
			
		},
		CLUSTER("CLUSTER"){

			@Override
			ObjectName getName() {
				return ObjectNameImpl.clusterName;
			}

			@Override
			ObjectList getObjectList() {
				ClusterRepDao clusterRepDao = new ClusterRepDao();
				List<Object> genericList = new ArrayList<>();
				List<ClusterRep> allClusterReps = new ArrayList<ClusterRep>();
				for (ClusterRep aClusterRep : allClusterReps){
					Object object = (Object) aClusterRep;
					genericList.add(object);
				}
				return (ObjectList) genericList;
			}
			
		}
		;
	
	private String type;
	private RenameObjectType( String type){
		
	}
	
	abstract ObjectName getName();
	abstract ObjectList getObjectList();

};

