package com.zenred.cosmos.controller;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.cosmos.controller.json.SystemView;
import com.zenred.cosmos.domain.Rename;
import com.zenred.cosmos.domain.RenamedSystem;
import com.zenred.cosmos.domain.System;
import com.zenred.cosmos.domain.SystemDao;
import com.zenred.cosmos.service_rules_and_infrastructure.EntityRenameExistsDecomposed;
import com.zenred.cosmos.service_rules_and_infrastructure.ImergeFromHyperspace;
import com.zenred.cosmos.vizualization.NamedSystemResponse;
import com.zenred.cosmos.vizualization.SystemResponse;

class IsEntityRenamed implements Controller {
	private static Logger logger = Logger.getLogger(IsEntityRenamed.class);

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		logger.info("SESSION ID:"+request.getRequestedSessionId());
		String  genericName = request.getParameter("genericName");
		String  type = request.getParameter("type");
		List<Rename> renameList = EntityRenameExistsDecomposed.doesEntryExist(type, genericName);
		ModelAndView modelAndView = new ModelAndView(new SystemView());
		modelAndView.addObject(SystemView.JSON_ROOT, null);
		logger.info(modelAndView);
		return modelAndView;
	}

}
