package com.zenred.johntredden.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.johntredden.controller.json.FirstAccessView;
import com.zenred.johntredden.domain.QuestionDao;
import com.zenred.johntredden.domain.User;
import com.zenred.johntredden.domain.UserDao;
import com.zenred.johntredden.domain.UserStatus;
import com.zenred.johntredden.vizualization.FirstAccessResponse;

public class FirstAccess implements Controller, StateIF {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		response.addHeader("Access-Control-Allow-Origin", "*");
//		HttpSession httpSession =  request.getSession();
		UUID idOne = UUID.randomUUID();
//		httpSession.setAttribute(FIRST_ACCESS, idOne.toString());
		System.out.println(FIRST_ACCESS+":"+idOne.toString());
		log.info(FIRST_ACCESS+":"+idOne.toString());
		UserDao userDao = new UserDao();
		User user = new User();
		user.setPassword(idOne.toString());
		user.setUser_Status(UserStatus.candidate1);
		user.setFirstName("NONE");
		user.setLastName("NONE");
		user.setEmailAddress("NONE@bog.us");
		userDao.createUser(user);
		
		FirstAccessResponse firstAccessResponse = new FirstAccessResponse();
		QuestionDao questionDao = new QuestionDao();
		List<Integer> questionGroupList = questionDao.questionGroupCollecton();
		Integer numberOfQuestions = questionDao.numberOfQuestions();
		int questionNumber = (int)Math.floor(Math.random()*numberOfQuestions);
		int listNumber = questionGroupList.get(questionNumber);
//		httpSession.setAttribute(QUESTION_NUMBER, listNumber);
		firstAccessResponse.setKey(idOne.toString());
		firstAccessResponse.setQuestionNumber(listNumber);
		firstAccessResponse.setQuestionList(questionDao.readQuestion(listNumber));
		ModelAndView modelAndView = new ModelAndView(new FirstAccessView());
		modelAndView.addObject(FirstAccessView.JSON_ROOT, firstAccessResponse);
		System.out.println(modelAndView);
		return modelAndView;

	}

}
