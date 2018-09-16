package com.zenred.cosmos.domain;

interface ObjectName{
	String objectName();
}

class ObjectNameImpl{
	protected static ObjectName planetoidName = new ObjectName(){
		public String objectName(){
			return "planetoidName";
		}
	};
}

public enum RenameObjectType {
		PLANETOID,
		STAR,
		CLUSTER
};