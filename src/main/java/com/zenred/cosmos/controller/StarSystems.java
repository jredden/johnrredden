package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.SystemView;
import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;
import com.zenred.cosmos.vizualization.SystemResponse;

class StarSystems implements Controller {
	private static Logger logger = Logger.getLogger(StarSystems.class);

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		SystemResponse systemResponse = ImergeFromHyperspace.dontKnowWhereShipIs();
		ModelAndView modelAndView = new ModelAndView(new SystemView());
		modelAndView.addObject(SystemView.JSON_ROOT, systemResponse);
		logger.info(modelAndView);
		return modelAndView;
	}

}
