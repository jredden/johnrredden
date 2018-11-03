package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.BasicMessageView;
import com.zenred.cosmos.domain.AddNewName;
import com.zenred.cosmos.domain.RenameObjectType;
import com.zenred.cosmos.vizualization.BasicMessageResponse;

public class RenameEntity implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String genericName = request.getParameter("genericName");
		String rename = request.getParameter("rename");
		RenameObjectType renameObjectType = RenameObjectType.valueOf(request.getParameter("type"));
		AddNewName.doIt(renameObjectType, rename, genericName);
		BasicMessageResponse basicMessageResponse = new BasicMessageResponse();
		basicMessageResponse.setTheMessage(genericName + " renamed " + rename); 
		ModelAndView modelAndView = new ModelAndView(new BasicMessageView());
		modelAndView.addObject(BasicMessageView.JSON_ROOT, basicMessageResponse);
		return modelAndView;
	}

}
