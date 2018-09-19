package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

import com.zenred.cosmos.domain.RenameObjectType;
public class Rename {
	
	public Integer getRenameId() {
		return renameId;
	}
	public void setRenameId(Integer renameId) {
		this.renameId = renameId;
	}
	public Integer getObjectId() {
		return objectId;
	}
	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}
	public RenameObjectType getRenameObjectType() {
		return renameObjectType;
	}
	public void setRenameObjectType(RenameObjectType renameObjectType) {
		this.renameObjectType = renameObjectType;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	public String getRenameName() {
		return renameName;
	}
	public void setRenameName(String renameName) {
		this.renameName = renameName;
	}
	public Integer getRenameCount() {
		return renameCount;
	}
	public void setRenameCount(Integer renameCount) {
		this.renameCount = renameCount;
	}
	public String getDatestamp() {
		return datestamp;
	}
	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datestamp == null) ? 0 : datestamp.hashCode());
		result = prime * result + ((genericName == null) ? 0 : genericName.hashCode());
		result = prime * result + ((objectId == null) ? 0 : objectId.hashCode());
		result = prime * result + ((renameCount == null) ? 0 : renameCount.hashCode());
		result = prime * result + ((renameId == null) ? 0 : renameId.hashCode());
		result = prime * result + ((renameName == null) ? 0 : renameName.hashCode());
		result = prime * result + ((renameObjectType == null) ? 0 : renameObjectType.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rename other = (Rename) obj;
		if (datestamp == null) {
			if (other.datestamp != null)
				return false;
		} else if (!datestamp.equals(other.datestamp))
			return false;
		if (genericName == null) {
			if (other.genericName != null)
				return false;
		} else if (!genericName.equals(other.genericName))
			return false;
		if (objectId == null) {
			if (other.objectId != null)
				return false;
		} else if (!objectId.equals(other.objectId))
			return false;
		if (renameCount == null) {
			if (other.renameCount != null)
				return false;
		} else if (!renameCount.equals(other.renameCount))
			return false;
		if (renameId == null) {
			if (other.renameId != null)
				return false;
		} else if (!renameId.equals(other.renameId))
			return false;
		if (renameName == null) {
			if (other.renameName != null)
				return false;
		} else if (!renameName.equals(other.renameName))
			return false;
		if (renameObjectType != other.renameObjectType)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Rename [renameId=" + renameId + ", objectId=" + objectId + ", renameObjectType=" + renameObjectType
				+ ", genericName=" + genericName + ", renameName=" + renameName + ", renameCount=" + renameCount
				+ ", datestamp=" + datestamp + "]";
	}
	


	private Integer renameId;
	private Integer objectId;
	RenameObjectType renameObjectType;
	private String genericName;
	private String renameName;
	private Integer renameCount;
	private String datestamp;
	
	/**
	 * No Arg CTOR
	 */
	public Rename() {
		super();
	}

	
	/**
	 * CTOR
	 * @param renameId
	 * @param objectId
	 * @param renameObjectType
	 * @param genericName
	 * @param renameName
	 * @param renameCount
	 * @param datestamp
	 */
	public Rename(Integer renameId, Integer objectId, RenameObjectType renameObjectType, String genericName,
			String renameName, Integer renameCount, String datestamp) {
		super();
		this.renameId = renameId;
		this.objectId = objectId;
		this.renameObjectType = renameObjectType;
		this.genericName = genericName;
		this.renameName = renameName;
		this.renameCount = renameCount;
		this.datestamp = datestamp;
	}
	
	
	/**
	 * 
	 * used for database insert of rename 
	 * 
	 * @param renameObjectType
	 * @param genericName
	 * @param renameName
	 * @param renameCount
	 * @return
	 */
	public static Map<String, Object> getRenameMap(RenameObjectType renameObjectType, 
			String genericName, String renameName, Integer renameCount, Integer objectId){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(RenameDao.OBJECTID, objectId);
		map.put(RenameDao.OBJECTTYPE, renameObjectType);
		return map;
	}
};