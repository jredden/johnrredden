package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.StarAndPlanetsView;
import com.zenred.cosmos.service_rules_and_infrastructure.ToStarsPlanets;
import com.zenred.cosmos.vizualization.PlanetsResponse;

public class StarAndPlanets implements Controller {

	private static Logger logger = Logger.getLogger(StarAndPlanets.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		String starName = request.getParameter("starName");		
		
		PlanetsResponse planetsResponse = ToStarsPlanets.starAndPlanets(starName);
		ModelAndView modelAndView = new ModelAndView(new StarAndPlanetsView());
		modelAndView.addObject(StarAndPlanetsView.JSON_ROOT, planetsResponse);
		logger.info(modelAndView);
		return modelAndView;
	}

}
