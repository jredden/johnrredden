package com.zenred.johntredden.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.zenred.uitil.GenName;

public class CreateUserDaoTest {

	@Test
	public void test() {
		String randomEmailAddress = "fundit@fun_" + Math.random() +".org";
		String randomPassword = "stupid_"+(Math.random());
		UserDao userDao = new UserDao();
		User user = new User();
		user.setEmailAddress(randomEmailAddress);
		user.setFirstName("Elmer");
		user.setLastName("Fudd");
		user.setPassword(randomPassword);
		user.setUser_Status(UserStatus.candidate1);
		userDao.createUser(user);
		User user2 = userDao.readUser(randomEmailAddress, randomPassword);
		assertNotNull(user2);
		System.out.println(user2);
		userDao.updateUserStatusToCandidate2(randomPassword);
		user2 = userDao.readUser(randomEmailAddress, randomPassword);
		assertNotNull(user2);
		System.out.println(user2);
		
		GenName.setPrefix("Bubba");
		GenName.setSpecialCharaChance(0);
		user2.setEmailAddress(GenName.generate(10)+"@"+GenName.generate(3));
		GenName.setPrefix("");
		user2.setFirstName(GenName.generate(8));
		user2.setLastName(GenName.generate(12));
		user2.setPassword(GenName.generate(25));
		
		userDao.updateUserAsRegistered(randomPassword, user2);
		user2 = userDao.readUser(user2.getEmailAddress(), user2.getPassword());
		System.out.println(user2);
		
		userDao.deleteUser(user2.getPassword());
	}

}
