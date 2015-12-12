package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.SectorsView;
import com.zenred.cosmos.report.GenCSV;
import com.zenred.cosmos.vizualization.SectorsResponse;

public class SystemReportChoice implements Controller {

	private static Logger logger = Logger.getLogger(SystemReportChoice.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());		
		SectorsResponse sectorsResponse = GenCSV.sectorsResponse();
		ModelAndView modelAndView = new ModelAndView(new SectorsView());
		modelAndView.addObject(SectorsView.JSON_ROOT, sectorsResponse);
		logger.info(modelAndView);
		return modelAndView;
	}

}
