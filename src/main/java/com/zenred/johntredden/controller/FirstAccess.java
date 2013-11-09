package com.zenred.johntredden.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.zenred.johntredden.controller.json.FirstAccessView;
import com.zenred.johntredden.domain.QuestionDao;
import com.zenred.johntredden.domain.User;
import com.zenred.johntredden.domain.UserDao;
import com.zenred.johntredden.domain.UserStatus;
import com.zenred.johntredden.vizualization.FirstAccessResponse;

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
		
		FirstAccessResponse firstAccessResponse = new FirstAccessResponse();
		QuestionDao questionDao = new QuestionDao();
		List<Integer> questionGroupList = questionDao.questionGroupCollecton();
		Integer numberOfQuestions = questionDao.numberOfQuestions();
		int questionNumber = (int)Math.floor(Math.random()*numberOfQuestions);
		int listNumber = questionGroupList.get(questionNumber);

		firstAccessResponse.setQuestionList(questionDao.readQuestion(listNumber));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(FirstAccessView.JSON_ROOT, firstAccessResponse);
		return modelAndView;
	}

}
