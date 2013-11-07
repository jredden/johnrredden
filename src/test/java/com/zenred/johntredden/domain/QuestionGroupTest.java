package com.zenred.johntredden.domain;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class QuestionGroupTest {

	@Test
	public void test() {
		QuestionDao questionDao = new QuestionDao();
		List<Integer> questionGroupList = questionDao.questionGroupCollecton();
		System.out.println(questionGroupList);
		assertTrue(0 != questionGroupList.size() );
		
	}

}
