package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.StarsView;
import com.zenred.cosmos.service_rules_and_infrastructure.ExamineSystems;
import com.zenred.cosmos.vizualization.ClusterResponse;

public class StarCluster implements Controller {

	private static Logger logger = Logger.getLogger(StarCluster.class);
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		String systemName = request.getParameter("systemName");
		ClusterResponse clusterResponse = ExamineSystems.starsInCluster(systemName);
		ModelAndView modelAndView = new ModelAndView(new StarsView());
		modelAndView.addObject(StarsView.JSON_ROOT, clusterResponse);
		logger.info(modelAndView);
		return modelAndView;
	}

}
