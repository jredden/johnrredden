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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AnswerQuestion1 implements Controller, StateIF {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		String answer = request.getParameter("question1");
		String key = request.getParameter("key");
//		HttpSession httpSession =  request.getSession();
		System.out.println("EntertempPassword:"+key+"::");
		log.info("EntertempPassword:"+key+"::");
		Integer questionGroupNumber = new Integer(request.getParameter("questionNumber"));
		QuestionDao questionDao = new QuestionDao();
		QuestionResponse questionResponse = new QuestionResponse();
		String correctAnswer = questionDao.getAnswer(questionGroupNumber);
		if(answer.equalsIgnoreCase(correctAnswer)){
			String tempPassword = key;
			System.out.println("tempPassword:"+tempPassword+"::");
			log.info("tempPassword:"+tempPassword+"::");
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
			System.out.println("answer:"+correctAnswer+"::"+answer);
			log.info("tempPassword:"+correctAnswer+"::"+answer);

		}

		
		
		ModelAndView modelAndView = new ModelAndView(new QuestionResponseView());
		modelAndView.addObject(QuestionResponseView.JSON_ROOT, questionResponse);
		System.out.println(modelAndView);
		return modelAndView;

	}

}
