package com.zenred.cosmos.vizualization;
import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("systems")
public class NamedSystemResponse {
	
	private NamedSystemVizCentric namedSystemVizCentric;

	public NamedSystemVizCentric getNamedSystemVizCentric() {
		return namedSystemVizCentric;
	}

	public void setNamedSystemVizCentric(NamedSystemVizCentric namedSystemVizCentric) {
		this.namedSystemVizCentric = namedSystemVizCentric;
	}

	@Override
	public String toString() {
		return "NamedSystemResponse [namedSystemVizCentric=" + namedSystemVizCentric + "]";
	}
	
	

}
