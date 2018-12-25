package com.zenred.cosmos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import com.zenred.cosmos.domain.RenameObjectType;
import com.zenred.cosmos.service_rules_and_infrastructure.NamedSystemDestinations;
import com.zenred.cosmos.vizualization.GenericRenameResponseForDestintion;


public class ListRenamedEntities implements Controller {
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String objectType = request.getParameter("objectType");
		RenameObjectType renameObjectType = RenameObjectType.valueOf(request.getParameter(objectType));
		List<GenericRenameResponseForDestintion> responseList = NamedSystemDestinations.returnSelections(renameObjectType);
		
		return null;
	}

}
