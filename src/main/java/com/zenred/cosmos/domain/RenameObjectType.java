package com.zenred.cosmos.domain;

import java.util.ArrayList;
import java.util.List;

interface ObjectName{
	String objectName();
}

interface ObjectList{
	void objectListImpl(List<Object> objectList);
	List<Object> getObjectList();
	
}

interface Entity{
	Boolean renameEntity(String genericName, String reName);
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
				
				ObjectList objectList = new ObjectList() {
					List<Object> list;
					@Override
					public void objectListImpl(List<Object> genericList) {
						list = genericList;
					}
					@Override
					public List<Object> getObjectList() {
						return list;
					}
				};
				objectList.objectListImpl(genericList);
				return objectList;
			}
			
			@Override
			Boolean renameEntity(String genericName, String reName)	{
				PlanetoidDao planetoidDao = new PlanetoidDao();
				Planetoid planetoid = planetoidDao.readPlanetoidByName(genericName);
				RenameDao renameDao = new RenameDao();
				renameDao.addNewName(PLANETOID, planetoid.getPlanetoidId(), reName, genericName);
				return true;
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
				allStars = starDao.readAllStars();
				for (Star aStar : allStars){
					Object object = (Object) aStar;
					genericList.add(object);
				}
				
				ObjectList objectList = new ObjectList() {
					List<Object> list;
					@Override
					public void objectListImpl(List<Object> genericList) {
						list = genericList;
					}
					@Override
					public List<Object> getObjectList() {
						return list;
					}
				};
				objectList.objectListImpl(genericList);
				return objectList;
			}
			
			@Override
			Boolean renameEntity(String genericName, String reName)	{
				StarDao starDao = new StarDao();
				Star star = starDao.readStarByName(genericName);
				RenameDao renameDao = new RenameDao();
				renameDao.addNewName(STAR, star.getStarId(), reName, genericName);
				return true;
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
				allClusterReps = clusterRepDao.readAllClusterReps();
				for (ClusterRep aClusterRep : allClusterReps){
					Object object = (Object) aClusterRep;
					genericList.add(object);
				}
				
				ObjectList objectList = new ObjectList() {
					List<Object> list;
					@Override
					public void objectListImpl(List<Object> genericList) {
						list = genericList;
					}
					@Override
					public List<Object> getObjectList() {
						return list;
					}
				};
				objectList.objectListImpl(genericList);
				return objectList;
			}
			
			@Override
			Boolean renameEntity(String genericName, String reName)	{
				ClusterRepDao clusterRepDao = new ClusterRepDao();
				ClusterRep clusterRep = clusterRepDao.readClusterRepByName(genericName);
				RenameDao renameDao = new RenameDao();
				renameDao.addNewName(CLUSTER, clusterRep.getClusterRepId(), reName, genericName);
				return true;
			}

			
		}
		;
	
	private String type;
	private RenameObjectType( String type){
		
	}
	
	abstract Boolean renameEntity(String genericName, String reName);

	abstract ObjectName getName();
	abstract ObjectList getObjectList();

};

