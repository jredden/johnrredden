package com.zenred.cosmos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.RenamePlanetoidsView;
import com.zenred.cosmos.service_rules_and_infrastructure.PlanetoidRenameCandidates;
import com.zenred.cosmos.service_rules_and_infrastructure.RenameCandidates;

public class ListAllPlanetoidRenamingCandidates implements Controller{
	
	private static Logger logger = Logger.getLogger(ListAllPlanetoidRenamingCandidates.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		PlanetoidRenameCandidates planetoidRenameCandidates = new PlanetoidRenameCandidates();
		List<RenameCandidates>  renameCandidates = planetoidRenameCandidates.buildList();
		ModelAndView modelAndView = new ModelAndView(new RenamePlanetoidsView());
		modelAndView.addObject(RenamePlanetoidsView.JSON_ROOT, renameCandidates);
		logger.info(modelAndView);
		return modelAndView;
	}

}
