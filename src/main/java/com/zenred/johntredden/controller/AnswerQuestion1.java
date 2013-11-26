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
import com.zenred.johntredden.vizualization.FirstAccessResponse;
import com.zenred.johntredden.vizualization.QuestionResponse;

public class AnswerQuestion1 implements Controller, StateIF {
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		response.addHeader("Access-Control-Allow-Origin", "*");
		String answer = request.getParameter("question1");
		HttpSession httpSession =  request.getSession();
		Integer questionGroupNumber = (Integer) httpSession.getAttribute(QUESTION_NUMBER);
		QuestionDao questionDao = new QuestionDao();
		QuestionResponse questionResponse = new QuestionResponse();
		String correctAnswer = questionDao.getAnswer(questionGroupNumber);
		if(answer.equalsIgnoreCase(correctAnswer)){
			String tempPassword = (String) httpSession.getAttribute(FIRST_ACCESS);
			System.out.println("tempPassword:"+tempPassword+"::");
			UserDao userDao = new UserDao();
			userDao.updateUserStatusToCandidate2(tempPassword);
			questionResponse.setTheMessage("SUCCESS");
			int secondQuestionNumber1 = (int)Math.floor(Math.random()*100);
			int secondQuestionNumber2 = (int)Math.floor(Math.random()*100);
			String secondQuestion = secondQuestionNumber1 + "+" + secondQuestionNumber2;
			questionResponse.setSecondQuestion(secondQuestion);
		}
		else{
			questionResponse.setTheMessage("FAIL");
		}

		
		
		ModelAndView modelAndView = new ModelAndView(new QuestionResponseView());
		modelAndView.addObject(QuestionResponseView.JSON_ROOT, questionResponse);
		System.out.println(modelAndView);
		return modelAndView;

	}

}
