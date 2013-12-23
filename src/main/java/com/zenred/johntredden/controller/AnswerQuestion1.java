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
		
		System.out.println("SESSION ID:"+request.getRequestedSessionId());
		String answer1 = request.getParameter("question1");
		String answer2 = request.getParameter("question2");
		int mathResponse = new Integer(answer2).intValue();

		Integer questionGroupNumber = new Integer(request.getParameter("questionNumber1"));
		QuestionDao questionDao = new QuestionDao();
		QuestionResponse questionResponse = new QuestionResponse();
		String correctAnswer = questionDao.getAnswer(questionGroupNumber);
		
		String [] mathQuestion = request.getParameter("questionNumber2").split("\\+");
		Integer mathAnswer = new Integer(mathQuestion[0] + new Integer(mathQuestion[1]));
		if(answer1.equalsIgnoreCase(correctAnswer)  && mathAnswer.intValue() == mathResponse){
			questionResponse.setTheMessage("SUCCESS");
		}
		else{
			questionResponse.setTheMessage("FAIL");
			System.out.println("answer:"+correctAnswer+"::"+answer1+"::"+ mathResponse+ ":m2:"+mathAnswer.intValue());
			log.info("answer:"+correctAnswer+"::"+answer1+":m1:"+ mathResponse + ":m2:"+mathAnswer.intValue());

		}

		
		
		ModelAndView modelAndView = new ModelAndView(new QuestionResponseView());
		modelAndView.addObject(QuestionResponseView.JSON_ROOT, questionResponse);
		System.out.println(modelAndView);
		return modelAndView;

	}

}
