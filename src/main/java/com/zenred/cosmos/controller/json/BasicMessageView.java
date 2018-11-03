package com.zenred.cosmos.controller.json;

import com.zenred.cosmos.vizualization.BasicMessageResponse;
import com.zenred.johntredden.controller.json.AbstractJsonView;

public class BasicMessageView extends AbstractJsonView {
	
	public BasicMessageView(){
		super(BasicMessageResponse.class);
	}

}
