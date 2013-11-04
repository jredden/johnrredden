package com.zenred.johntredden.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class NumberQuestonsDaoTest {

	@Test
	public void test() {
		QuestionDao questionDao = new QuestionDao();
		Integer answer = questionDao.numberOfQuestions();
		assertNotNull(answer);
		System.out.println(answer);
	}

}
