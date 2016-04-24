package com.divya.myfandango.service;

import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.divya.myfandango.entity.impl.UserImpl;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestLoginService extends AbstractJUnit4SpringContextTests {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserImpl user; 
	
	@Test
	public void testUserAuthentication(){
		String result = loginService.userAuthentication("111", "dv123", "Customer");
		Assert.assertEquals("Success", result);
	}
	
	@Test
	public void testUserAuthenticationFailure(){
		String result = loginService.userAuthentication("123", "dv123", "Customer");
		Assert.assertEquals("Failure", result);
	}
	
	@Test
	public void testCreateNewUser(){
		user.setUserName("divya");
		user.setUserID(12);
		user.setPassword("123");
//		user.setUserType("Customer");
		String result = loginService.createNewUser(user);
		Assert.assertEquals("Successfully created User", result);
	}
	
	@Test
	public void testCreateNewUserFailure(){
		user = null;
		String result = loginService.createNewUser(user);
		Assert.assertEquals("Failure", result);
	}
	
	
	@Test
	public void testResetPassword(){
		String userID ="1234dv";
		String password ="1234dv";
		String result = loginService.resetPassword(userID, password);
		Assert.assertEquals("Successfully changed password", result);
	}
	
	@Test
	public void testResetPasswordFailure(){
		String userID ="1234dv";
		String password = "d";
		String result = loginService.resetPassword(userID, password);
		Assert.assertEquals("Failure", result);
	}
	

	

}
