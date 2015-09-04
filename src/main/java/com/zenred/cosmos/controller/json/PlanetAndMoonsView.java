package com.zenred.cosmos.controller.json;

import com.zenred.cosmos.vizualization.MoonsResponse;
import com.zenred.johntredden.controller.json.AbstractJsonView;

public class PlanetAndMoonsView extends AbstractJsonView {
	public PlanetAndMoonsView(){
		super(MoonsResponse.class);
	}
}
