package com.zenred.cosmos.controller;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.SystemView;
import com.zenred.cosmos.domain.System;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;
import com.zenred.cosmos.vizualization.SystemResponse;

class VisitStarSystem implements Controller {
	private static Logger logger = Logger.getLogger(VisitStarSystem.class);

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		String  s_Ucoordinate_top = request.getParameter("s_Ucoordinate_top");	
		String  s_Vcoordinate_top = request.getParameter("s_Vcoordinate_top");
		Integer i_Ucoordinate = new Integer(s_Ucoordinate_top);
		Integer i_Vcoordinate = new Integer(s_Vcoordinate_top);
		Double d_Ucoordinate = new Double(s_Ucoordinate_top);
		Double d_Vcoordinate = new Double(s_Vcoordinate_top);
		SystemDao systemDao = new SystemDao();
		if(!systemDao.doesSystemExist(d_Ucoordinate, d_Vcoordinate)){
			// should never get here
			throw new RuntimeErrorException(new Error(), "System Not Exist:"+s_Ucoordinate_top+"::"+s_Vcoordinate_top);
		}
		System system = systemDao.readSystemByUVCoordinates(i_Ucoordinate, i_Vcoordinate);
		SystemResponse systemResponse = ImergeFromHyperspace.doesKnowWhereShipIs(system);
		ModelAndView modelAndView = new ModelAndView(new SystemView());
		modelAndView.addObject(SystemView.JSON_ROOT, systemResponse);
		logger.info(modelAndView);
		return modelAndView;
	}

}
