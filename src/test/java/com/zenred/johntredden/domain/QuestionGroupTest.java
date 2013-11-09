package com.zenred.johntredden.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class QuestionGroupTest {

	@Test
	public void test() {
		QuestionDao questionDao = new QuestionDao();
		List<Integer> questionGroupList = questionDao.questionGroupCollecton();
		System.out.println(questionGroupList);
		assertTrue(0 != questionGroupList.size() );
		Integer numberOfQuestions = questionDao.numberOfQuestions();
		int questionNumber = (int)Math.floor(Math.random()*numberOfQuestions);
		int listNumber = questionGroupList.get(questionNumber);
		List<String> questionList = questionDao.readQuestion(listNumber);
		System.out.println(questionList);
		assertTrue(0 != questionList.size() );
	}
	@Ignore
	@Test
	public void testRand(){
		QuestionDao questionDao = new QuestionDao();
		int number_of_questions = questionDao.numberOfQuestions();
		for (int idex = 0; idex <100; idex++){
			int questionNumber = (int)Math.floor(Math.random()*number_of_questions);
			System.out.println(questionNumber);
		}
	}
	
	@Test
	public void testMore(){
		test();
		test();
		test();
		test();
		test();
		test();
		test();
		test();
		test();
	}
}
