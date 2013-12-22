package com.zenred.johntredden.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sun.swing.internal.plaf.basic.resources.basic;
import com.zenred.johntredden.controller.json.BasicMessageView;
import com.zenred.johntredden.domain.QuestionDao;
import com.zenred.johntredden.domain.User;
import com.zenred.johntredden.domain.UserDao;
import com.zenred.johntredden.vizualization.BasicMessageResponse;

public class Login implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// response.setContentType("application/javascript");
		// response.setHeader("jsonpCallback", "processJson");
		response.addHeader("Access-Control-Allow-Origin", "*");
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
			QuestionDao questionDao = new QuestionDao();
			List<Integer> questionGroupList = questionDao.questionGroupCollecton();
			Integer numberOfQuestions = questionDao.numberOfQuestions();
			int questionNumber = (int)Math.floor(Math.random()*numberOfQuestions);
			int listNumber = questionGroupList.get(questionNumber);
			basicMessageResponse.setQuestionNumber(listNumber);
			basicMessageResponse.setQuestionList(questionDao.readQuestion(listNumber));
			int secondQuestionNumber1 = (int)Math.floor(Math.random()*100);
			int secondQuestionNumber2 = (int)Math.floor(Math.random()*100);
			String secondQuestion = secondQuestionNumber1 + "+" + secondQuestionNumber2;
			basicMessageResponse.setSecondQuestion(secondQuestion);
			basicMessageResponse.setTheMessage("SignUp");
			modelAndView.addObject(BasicMessageView.JSON_ROOT, basicMessageResponse);
			return modelAndView;
		}
		basicMessageResponse.setTheMessage("Passed");
		modelAndView.addObject(BasicMessageView.JSON_ROOT, basicMessageResponse);
		return modelAndView;
	}

}
