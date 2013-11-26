package com.zenred.johntredden.domain;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class AnswerTest {

	@Test
	public void test() {
		QuestionDao questionDao = new QuestionDao();
		List<Integer> questionGroupList = questionDao.questionGroupCollecton();
		Integer numberOfQuestions = questionDao.numberOfQuestions();
		for (Integer number = 0; number < numberOfQuestions; number++){
			int listNumber = questionGroupList.get(number);
			String answer = questionDao.getAnswer(listNumber);
			assertNotNull(answer);
			System.out.println(answer);
		}
	}

}
