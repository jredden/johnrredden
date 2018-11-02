package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.domain.RenameObjectType;

public class RenameEntity implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String genericName = request.getParameter("genericName");
		String rename = request.getParameter("rename");
		RenameObjectType renameObjectType = RenameObjectType.valueOf(request.getParameter("type"));
		
		return null;
	}

}
