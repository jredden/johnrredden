package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.PlanetAndMoonsView;
import com.zenred.cosmos.service_rules_and_infrastructure.ToPlanetAndMoons;
import com.zenred.cosmos.vizualization.MoonsResponse;

public class PlanetAndMoons implements Controller {

	private static Logger logger = Logger.getLogger(PlanetAndMoons.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		String starName = request.getParameter("starName");	
		String planetName = request.getParameter("planetName");	
		
		MoonsResponse moonsResponse = ToPlanetAndMoons.planarAndMoons(planetName, starName);
		ModelAndView modelAndView = new ModelAndView(new PlanetAndMoonsView());
		modelAndView.addObject(PlanetAndMoonsView.JSON_ROOT, moonsResponse);
		logger.info(modelAndView);
		return modelAndView;
	}

}
