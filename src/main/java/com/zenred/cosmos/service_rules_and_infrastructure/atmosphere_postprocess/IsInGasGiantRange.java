package com.zenred.cosmos.service_rules_and_infrastructure.atmosphere_postprocess;

import com.zenred.cosmos.domain.Planetoid;
import com.zenred.cosmos.service_rules_and_infrastructure.RadiusRangeConstant;

public class IsInGasGiantRange {
	
	private Planetoid planetoid;
	
	public IsInGasGiantRange(Planetoid planetoid) {
		this.planetoid = planetoid;
	}

	public Planetoid getPlanetoid() {
		return planetoid;
	}

	public void setPlanetoid(Planetoid planetoid) {
		this.planetoid = planetoid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((planetoid == null) ? 0 : planetoid.hashCode());
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
		IsInGasGiantRange other = (IsInGasGiantRange) obj;
		if (planetoid == null) {
			if (other.planetoid != null)
				return false;
		} else if (!planetoid.equals(other.planetoid))
			return false;
		return true;
	}
	
	/**
	 * 
	 * @param size
	 * @return if in gas giant range
	 */
	public boolean sizeRange(Double size){
		boolean answer = false;
		if(size >= RadiusRangeConstant.MINI_GAS_GIANT_PLANETOID){
			answer = true;
		}
		return answer;
	}

}
