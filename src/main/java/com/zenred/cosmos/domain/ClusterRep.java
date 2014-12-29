package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

public class ClusterRep {
	
	public ClusterRep(){}
	
	public ClusterRep(Integer clusterRepId, Integer systemId,
			String clusterName, Double distance_sys_virt_centre,
			Double angle_in_radians, String cluster_type,
			String dateStamp) {
		super();
		this.clusterRepId = clusterRepId;
		this.systemId = systemId;
		this.clusterName = clusterName;
		this.distance_sys_virt_centre = distance_sys_virt_centre;
		this.angle_in_radians = angle_in_radians;
		this.cluster_type = cluster_type;
		DateStamp = dateStamp;
	}
	
	private Integer clusterRepId;
	private Integer systemId;
	private String clusterName;
	private Double distance_sys_virt_centre;
	private Double angle_in_radians;
	private String cluster_type;
	private String DateStamp;
	
	public Integer getClusterRepId() {
		return clusterRepId;
	}
	public void setClusterRepId(Integer clusterRepId) {
		this.clusterRepId = clusterRepId;
	}
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public String getClusterName() {
		return clusterName;
	}
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}
	public Double getDistance_sys_virt_centre() {
		return distance_sys_virt_centre;
	}
	public void setDistance_sys_virt_centre(Double distance_sys_virt_centre) {
		this.distance_sys_virt_centre = distance_sys_virt_centre;
	}
	public Double getAngle_in_radians() {
		return angle_in_radians;
	}
	public void setAngle_in_radians(Double angle_in_radians) {
		this.angle_in_radians = angle_in_radians;
	}
	public String getCluster_description() {
		return cluster_type;
	}
	public void setCluster_description(String cluster_type) {
		this.cluster_type = cluster_type;
	}
	public String getDateStamp() {
		return DateStamp;
	}
	public void setDateStamp(String dateStamp) {
		DateStamp = dateStamp;
	}
	
	/**
	 * 
	 * @return database centric map used for inserts
	 */
	public Map<String, Object> getMap(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("systemId", this.systemId);
		map.put("clusterName", this.clusterName);
		map.put("distance_sys_virt_centre", this.distance_sys_virt_centre);
		map.put("angle_in_radians", this.angle_in_radians);
		map.put("cluster_description", this.cluster_type);
		return map;
	}

	public static String [] csvSeparatedColumns() {
		return new String[]{"systemId","clusterName","distance_sys_virt_centre","angle_in_radians", "cluster_description"};
	}

	@Override
	public String toString() {
		return "ClusterRep [clusterRepId=" + clusterRepId + ", systemId="
				+ systemId + ", clusterName=" + clusterName
				+ ", distance_sys_virt_centre=" + distance_sys_virt_centre
				+ ", angle_in_radians=" + angle_in_radians + ", cluster_type="
				+ cluster_type + ", DateStamp=" + DateStamp + "]";
	}

}
