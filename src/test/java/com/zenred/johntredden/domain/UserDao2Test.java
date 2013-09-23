package com.zenred.johntredden.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UserDao2Test {

	@Test
	public void test() {
		UserDao userDao = new UserDao();
		User user = userDao.readUser("john", "redden", "mek1952");
		assertNotNull(user);
		System.out.println(user);
	}

}
