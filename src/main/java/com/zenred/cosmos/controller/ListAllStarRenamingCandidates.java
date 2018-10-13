package com.zenred.cosmos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.RenameStarsView;
import com.zenred.cosmos.service_rules_and_infrastructure.StarRenameCandidates;
import com.zenred.cosmos.service_rules_and_infrastructure.RenameCandidates;

public class ListAllStarRenamingCandidates implements Controller{
	
	private static Logger logger = Logger.getLogger(ListAllStarRenamingCandidates.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		StarRenameCandidates starRenameCandidates = new StarRenameCandidates();
		List<RenameCandidates>  renameCandidates = starRenameCandidates.buildList();
		ModelAndView modelAndView = new ModelAndView(new RenameStarsView());
		modelAndView.addObject(RenameStarsView.JSON_ROOT, renameCandidates);
		logger.info(modelAndView);
		return modelAndView;
	}

}
