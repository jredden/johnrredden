package com.zenred.johntredden.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserDaoTest {

	@Test
	public void test() {
		UserDao userDao = new UserDao();
		User user = userDao.readUser("johnredden@aol.com", "mek1952");
		assertNotNull(user);
		System.out.println(user);
	}

}
