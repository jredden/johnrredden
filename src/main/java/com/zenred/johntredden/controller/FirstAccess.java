package com.zenred.johntredden.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.johntredden.domain.User;
import com.zenred.johntredden.domain.UserDao;
import com.zenred.johntredden.domain.UserStatus;

public class FirstAccess implements Controller {
	
	public static final String FIRST_ACCESS = UserStatus.candidate1.name();

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession httpSession =  request.getSession();
		UUID idOne = UUID.randomUUID();
		httpSession.setAttribute(FIRST_ACCESS, idOne.toString());
		UserDao userDao = new UserDao();
		User user = new User();
		user.setPassword(idOne.toString());
		user.setUser_Status(UserStatus.candidate1);
		userDao.createUser(user);
		return new ModelAndView();
	}

}
