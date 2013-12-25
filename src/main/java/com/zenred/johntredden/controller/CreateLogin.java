package com.zenred.johntredden.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.johntredden.controller.json.FirstAccessView;
import com.zenred.johntredden.controller.json.QuestionResponseView;
import com.zenred.johntredden.domain.QuestionDao;
import com.zenred.johntredden.domain.User;
import com.zenred.johntredden.domain.UserDao;
import com.zenred.johntredden.domain.UserStatus;
import com.zenred.johntredden.vizualization.CreateLoginResponse;
import com.zenred.johntredden.vizualization.FirstAccessResponse;
import com.zenred.johntredden.vizualization.QuestionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.validator.routines.EmailValidator;



public class CreateLogin implements Controller, StateIF {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		String emailAddress = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		CreateLoginResponse createLoginResponse = new CreateLoginResponse();
		
		EmailValidator emailValidator = EmailValidator.getInstance();
		if(!emailValidator.isValid(emailAddress)){
			createLoginResponse.setTheMessage("The e-mail address is non-standard:"+emailAddress);
		}
		else if(!password1.equals(password2)){
			createLoginResponse.setTheMessage("Passwords do not match");
		}
		createLoginResponse.setTheMessage("SUCCESS");
		return null;

	}

}
