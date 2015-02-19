package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

public class Star {
	
	private Integer starId;
	private Integer clusterToStarId;
	private String name;
	private Double distance_clust_virt_centre;
	private Double luminosity;
	private Boolean no_planets_allowed;
	private Double angle_in_radians_s;
	private String star_color;
	private String star_type;
	private Double star_size;
	private String datestamp;

	/**
	 * no arg CTOR
	 */
	public Star(){
		super();
	}

	/**
	 * CTOR with all attributes
	 * 
	 * @param starId
	 * @param clusterToStarId
	 * @param name
	 * @param distance_clust_virt_centre
	 * @param luminosity
	 * @param no_planets_allowed
	 * @param angle_in_radians_s
	 * @param star_color
	 * @param star_type
	 * @param star_size
	 * @param datestamp
	 */
	public Star(Integer starId, Integer clusterToStarId, String name,
			Double distance_clust_virt_centre, Double luminosity,
			Boolean no_planets_allowed, Double angle_in_radians_s,
			String star_color, String star_type, Double star_size,
			String datestamp) {
		super();
		this.starId = starId;
		this.clusterToStarId = clusterToStarId;
		this.name = name;
		this.distance_clust_virt_centre = distance_clust_virt_centre;
		this.luminosity = luminosity;
		this.no_planets_allowed = no_planets_allowed;
		this.angle_in_radians_s = angle_in_radians_s;
		this.star_color = star_color;
		this.star_type = star_type;
		this.star_size = star_size;
		this.datestamp = datestamp;
	}

	public Integer getStarId() {
		return starId;
	}

	public void setStarId(Integer starId) {
		this.starId = starId;
	}

	public Integer getClusterToStarId() {
		return clusterToStarId;
	}

	public void setClusterToStarId(Integer clusterToStarId) {
		this.clusterToStarId = clusterToStarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDistance_clust_virt_centre() {
		return distance_clust_virt_centre;
	}

	public void setDistance_clust_virt_centre(Double distance_clust_virt_centre) {
		this.distance_clust_virt_centre = distance_clust_virt_centre;
	}

	public Double getLuminosity() {
		return luminosity;
	}

	public void setLuminosity(Double luminosity) {
		this.luminosity = luminosity;
	}

	public Short getNo_planets_allowed() {
		Short one = new Short("1");
		Short zero = new Short("0");
		return no_planets_allowed == true? one:zero;
	}

	public void setNo_planets_allowed(Boolean no_planets_allowed) {
		this.no_planets_allowed = no_planets_allowed;
	}

	public Double getAngle_in_radians_s() {
		return angle_in_radians_s;
	}

	public void setAngle_in_radians_s(Double angle_in_radians_s) {
		this.angle_in_radians_s = angle_in_radians_s;
	}

	public String getStar_color() {
		return star_color;
	}

	public void setStar_color(String star_color) {
		this.star_color = star_color;
	}

	public String getStar_type() {
		return star_type;
	}

	public void setStar_type(String star_type) {
		this.star_type = star_type;
	}

	public Double getStar_size() {
		return star_size;
	}

	public void setStar_size(Double star_size) {
		this.star_size = star_size;
	}

	public String getDatestamp() {
		return datestamp;
	}

	public void setDatestamp(String datestamp) {
		this.datestamp = datestamp;
	}
	
	/**
	 * 
	 * @return database centric map used for inserts
	 */
	public Map<String, Object> getStarMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clusterToStarId", this.clusterToStarId);
		map.put("Name", this.name);
		map.put("distance_clust_virt_centre", this.distance_clust_virt_centre);
		map.put("luminosity", this.luminosity);
		map.put("no_planets_allowed", this.no_planets_allowed);
		map.put("angle_in_radians_s", this.angle_in_radians_s);
		map.put("star_color", this.star_color);
		map.put("star_type", this.star_type);
		map.put("star_size", this.star_size);
		return map;
	}

	/**
	 * refactor ... all the strings should come from immutable objects in StarDao
	 */
	
	/**
	 * 
	 * @return database centric map used for inserts
	 */
	public Map<String, Object> getClusterToStarMap(Integer clusterRepId, String sub_cluster_description) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("clusterRepId", clusterRepId);
		map.put("sub_cluster_description", sub_cluster_description);
		return map;
	}
	
	public static String[] csvStarSeparatedColumns() {
		return new String[] { "clusterToStarId", "Name",
				"distance_clust_virt_centre", "luminosity",
				"no_planets_allowed", "angle_in_radians_s", "star_color",
				"star_type", "star_size" };
	}
	
	public static String [] csvClusterToStarSeparatedColumns(){
		return new String[] {"clusterRepId", "sub_cluster_description"};
	}

	@Override
	public String toString() {
		return "Star [starId=" + starId + ", clusterToStarId="
				+ clusterToStarId + ", name=" + name
				+ ", distance_clust_virt_centre=" + distance_clust_virt_centre
				+ ", luminosity=" + luminosity + ", no_planets_allowed="
				+ no_planets_allowed + ", angle_in_radians_s="
				+ angle_in_radians_s + ", star_color=" + star_color
				+ ", star_type=" + star_type + ", star_size=" + star_size
				+ ", datestamp=" + datestamp + "]";
	}
	
	
}
