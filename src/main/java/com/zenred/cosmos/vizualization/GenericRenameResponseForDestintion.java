package com.zenred.cosmos.vizualization;


public class GenericRenameResponseForDestintion {
	
	private Integer uDimension;
	private Integer vDimension;
	private String renameObjectType;
	private String genericName;
	private String renameName;
	private Double distanceToGalacticCentre;
	
	public Integer getuDimension() {
		return uDimension;
	}
	public void setuDimension(Integer uDimension) {
		this.uDimension = uDimension;
	}
	public Integer getvDimension() {
		return vDimension;
	}
	public void setvDimension(Integer vDimension) {
		this.vDimension = vDimension;
	}
	public String getRenameObjectType() {
		return renameObjectType;
	}
	public void setRenameObjectType(String renameObjectType) {
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
	public Double getDistanceToGalacticCentre() {
		return distanceToGalacticCentre;
	}
	public void setDistanceToGalacticCentre(Double distanceToGalacticCentre) {
		this.distanceToGalacticCentre = distanceToGalacticCentre;
	}
	@Override
	public String toString() {
		return "GenericRenameResponseForDestintion [uDimension=" + uDimension + ", vDimension=" + vDimension
				+ ", renameObjectType=" + renameObjectType + ", genericName=" + genericName + ", renameName="
				+ renameName + ", distanceToGalacticCentre=" + distanceToGalacticCentre + "]";
	}

	
}
