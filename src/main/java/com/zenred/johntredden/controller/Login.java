package com.zenred.johntredden.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.johntredden.controller.json.BasicMessageView;
import com.zenred.johntredden.domain.User;
import com.zenred.johntredden.domain.UserDao;
import com.zenred.johntredden.vizualization.BasicMessageResponse;

public class Login implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		BasicMessageResponse basicMessageResponse = new BasicMessageResponse();
		ModelAndView modelAndView = new ModelAndView(new BasicMessageView());

		if(null == emailAddress || null == emailAddress){
			basicMessageResponse.setTheMessage("NoInput");
			modelAndView.addObject(BasicMessageView.JSON_ROOT, basicMessageResponse);
			return modelAndView;
		}
		UserDao userDao = new UserDao();
		User user = userDao.readUser(emailAddress, password);
		if(null == user){
			basicMessageResponse.setTheMessage("SignUp");
			modelAndView.addObject(BasicMessageView.JSON_ROOT, basicMessageResponse);
			return modelAndView;
		}
		basicMessageResponse.setTheMessage("Passed");
		modelAndView.addObject(BasicMessageView.JSON_ROOT, basicMessageResponse);
		return modelAndView;
	}

}
