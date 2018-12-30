package com.zenred.cosmos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.RenameResponseView;
import com.zenred.cosmos.domain.RenameObjectType;
import com.zenred.cosmos.service_rules_and_infrastructure.NamedSystemDestinations;
import com.zenred.cosmos.vizualization.GenericRenameResponseForDestintion;


public class ListRenamedEntities implements Controller {
	
	private static Logger logger = Logger.getLogger(ListRenamedEntities.class);
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String type = request.getParameter("objectType");
		logger.info("objectType:" + type);
		RenameObjectType renameObjectType = RenameObjectType.valueOf(type);
		List<GenericRenameResponseForDestintion> responseList = NamedSystemDestinations.returnSelections(renameObjectType);
		ModelAndView modelAndView = new ModelAndView(new RenameResponseView());
		modelAndView.addObject(RenameResponseView.JSON_ROOT, responseList);
		return modelAndView;
	}

}
