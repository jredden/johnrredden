package com.zenred.cosmos.service_rules_and_infrastructure.atmosphere_postprocess;

import com.zenred.cosmos.domain.Atmosphere;

public abstract class IsAnAtmosphere {
	
	private Atmosphere atmosphere;
	
	public IsAnAtmosphere(Atmosphere atmosphere){
		this.atmosphere = atmosphere;
	}

	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atmosphere == null) ? 0 : atmosphere.hashCode());
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
		IsAnAtmosphere other = (IsAnAtmosphere) obj;
		if (atmosphere == null) {
			if (other.atmosphere != null)
				return false;
		} else if (!atmosphere.equals(other.atmosphere))
			return false;
		return true;
	}
	
	

}
