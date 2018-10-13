package com.zenred.cosmos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.RenameClustersView;
import com.zenred.cosmos.service_rules_and_infrastructure.ClusterRenameCandidates;
import com.zenred.cosmos.service_rules_and_infrastructure.RenameCandidates;

public class ListAllClusterRenamingCandidates implements Controller{
	
	private static Logger logger = Logger.getLogger(ListAllClusterRenamingCandidates.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		ClusterRenameCandidates clusterRenameCandidates = new ClusterRenameCandidates();
		List<RenameCandidates>  renameCandidates = clusterRenameCandidates.buildList();
		ModelAndView modelAndView = new ModelAndView(new RenameClustersView());
		modelAndView.addObject(RenameClustersView.JSON_ROOT, renameCandidates);
		logger.info(modelAndView);
		return modelAndView;
	}

}
