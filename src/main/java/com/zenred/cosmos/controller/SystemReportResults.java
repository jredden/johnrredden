package com.zenred.cosmos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.SectorsView;
import com.zenred.cosmos.report.GenCSV;
import com.zenred.cosmos.vizualization.SectorsResponse;

public class SystemReportResults implements Controller {

	private static Logger logger = Logger.getLogger(SystemReportResults.class);
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());	
		String  s_Ucoordinate_top = request.getParameter("s_Ucoordinate_top");	
		String  s_Vcoordinate_top = request.getParameter("s_Vcoordinate_top");	
		String  s_Ucoordinate_bottom = request.getParameter("s_Ucoordinate_bottom");	
		String  s_Vcoordinate_bottom = request.getParameter("s_Vcoordinate_bottom");
		String fullPathToYourWebappRoot = com.zenred.cosmos.domain.Configuration.readReportRoot();
		logger.info("FUll_ROOT_PATH:"+fullPathToYourWebappRoot);
		SectorsResponse sectorsResponse = GenCSV.selectSector(s_Ucoordinate_top, s_Vcoordinate_top, s_Ucoordinate_bottom, s_Vcoordinate_bottom, fullPathToYourWebappRoot);
		ModelAndView modelAndView = new ModelAndView(new SectorsView());
		modelAndView.addObject(SectorsView.JSON_ROOT, sectorsResponse);
		response.setContentType("text/JSON");
		logger.info(modelAndView);
		return modelAndView;
	}

}
