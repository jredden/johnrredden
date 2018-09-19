package com.zenred.cosmos.domain;

interface ObjectName{
	String objectName();
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
			
		},
		STAR("STAR"){

			@Override
			ObjectName getName() {
				return ObjectNameImpl.starName;
			}
			
		},
		CLUSTER("CLUSTER"){

			@Override
			ObjectName getName() {
				return ObjectNameImpl.clusterName;
			}
			
		}
		;
	
	private String type;
	private RenameObjectType( String type){
		
	}
	
	abstract ObjectName getName();

};

