package com.zenred.cosmos.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Domain object of a galactic system of possible stars, possible planetoids.
 * 
 * Distance to the galactic centre is the distance in normal parsecs to the
 * galactic core. Ucoordinate is the U coordinate of the system in shift(hyper)
 * space. Vcoordinate is the V coordinate of the system in shift(hyper) space.
 * Datestamp is update or creation database timestamp
 * 
 * @author jredden
 *
 */
public class System {
	/**
	 * no arg CTOR
	 */
	public System(){
		super();
	}
	
	/**
	 * CTOR with all attributes
	 * 
	 * @param systemId
	 * @param distance_to_galaxy_centre
	 * @param ucoordinate
	 * @param vcoordinate
	 * @param datestamp
	 */
	public System(Integer systemId, Double distance_to_galaxy_centre,
			Double ucoordinate, Double vcoordinate, String datestamp) {
		super();
		this.systemId = systemId;
		this.distance_to_galaxy_centre = distance_to_galaxy_centre;
		this.ucoordinate = ucoordinate;
		this.vcoordinate = vcoordinate;
		Datestamp = datestamp;
	}

	private Integer systemId;
	private Double distance_to_galaxy_centre;
	private Double ucoordinate;
	private Double vcoordinate;
	private String Datestamp;
	private String systemName;

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	public Double getDistance_to_galaxy_centre() {
		return distance_to_galaxy_centre;
	}

	public void setDistance_to_galaxy_centre(Double distance_to_galaxy_centre) {
		this.distance_to_galaxy_centre = distance_to_galaxy_centre;
	}

	public Double getUcoordinate() {
		return ucoordinate;
	}

	public void setUcoordinate(Double ucoordinate) {
		this.ucoordinate = ucoordinate;
	}

	public Double getVcoordinate() {
		return vcoordinate;
	}

	public void setVcoordinate(Double vcoordinate) {
		this.vcoordinate = vcoordinate;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getDatestamp() {
		return Datestamp;
	}

	public void setDatestamp(String datestamp) {
		Datestamp = datestamp;
	}

	/**
	 * generate default system name
	 * @param instance
	 */
	public static void genSystemName(System instance) {
		instance.systemName = "U" + instance.ucoordinate.toString() + "V"
				+ instance.ucoordinate.toString();
	}

	/**
	 * 
	 * @return database centric map used for inserts
	 */
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("distance_to_galaxy_centre", this.distance_to_galaxy_centre);
		map.put("ucoordinate", this.ucoordinate);
		map.put("vcoordinate", this.vcoordinate);
		map.put("systemName", this.systemName);
		return map;
	}

	public static String [] csvSeparatedColumns() {
		return new String[]{"distance_to_galaxy_centre","ucoordinate","vcoordinate","systemName"};
	}

	@Override
	public String toString() {
		return "System [systemId=" + systemId + ", distance_to_galaxy_centre="
				+ distance_to_galaxy_centre + ", ucoordinate=" + ucoordinate
				+ ", vcoordinate=" + vcoordinate + ", Datestamp=" + Datestamp
				+ ", systemName=" + systemName + "]";
	}

}
