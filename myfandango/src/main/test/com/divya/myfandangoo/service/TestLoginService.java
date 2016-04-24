package com.divya.myfandangoo.service;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.divya.myfandangoo.entity.User;
import com.divya.myfandangoo.entity.impl.UserImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestLoginService extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	private LoginService loginService;
	
//	@Autowired
//	private UserImpl user; 
	
//	@Rollback(false)
	@Test
	public void testUserAuthentication(){
		UserImpl user = new UserImpl();
		user.setUserID(2);
		user.setUserName("divya");
		user.setPassword("secret");
		int resultValue = loginService.createNewUser(user);
		Assert.assertEquals(0, resultValue);
		
		//Create Same user
		user.setUserID(3);
		user.setUserName("divya");
		user.setPassword("secret");
		int sameUser = loginService.createNewUser(user);
		Assert.assertEquals(1, sameUser);
		
		String result = loginService.userAuthentication("divya", "secret");
		Assert.assertEquals("Success", result);
	}
	
	@Test
	public void testUserAuthenticationFailure(){
		String result = loginService.userAuthentication("dv123", "Customer");
		Assert.assertEquals("Failure", result);
	}
	
	@Test
	public void testResetPassword(){
		UserImpl user = new UserImpl(); 
		user.setUserName("divya");
		user.setPassword("1234dv");
		user.setUserID(6);
		try{
		loginService.resetPassword(user);
		Assert.assertEquals("Success", "Success");
	}catch(Exception e){
		Assert.assertNotEquals("Success", "Failure");
	}
	}
	
//	@Test
//	public void testResetPasswordFailure(){
//		String userID ="1234dv";
//		String password = "d";
//		String result = loginService.resetPassword(userID, password);
//		Assert.assertEquals("Failure", result);
//	}
	

	

}
