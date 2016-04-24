package com.divya.myfandangoo.http;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUserResources {
	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "myfandangoo/rest/users";

	private Client client = ClientBuilder.newClient();
	private WebTarget target;

	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}

//	@Test
//	public void testGetUsersNoParamsJson(){						
//		Response response =	target.request().accept(MediaType.APPLICATION_JSON).get();
//
//	}
//
//	@Test
//	public void testGetUsersNoParamsXml(){						
//		Response response =	target.request().accept(MediaType.APPLICATION_XML).get();
//
//	}
//	@Test
//	public void testCreateUsersNoParamsXml(){					
//		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<user/>", MediaType.APPLICATION_XML));
//
//	}
//
//	@Test
//	public void testCreateUsersNoParamsEntityXml(){					
//		HttpUser userToSend = new HttpUser();		
//		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(userToSend, MediaType.APPLICATION_XML));
//
//	}
//
//	@Test
//	public void testCreateUsersNoParamsJson(){					
//		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{user:{}}", MediaType.APPLICATION_JSON));
//
//	}
//
//	@Test
//	public void testCreateUsersNoParamsEntityJson(){					
//		HttpUser userToSend = new HttpUser();		
//		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
//
//	}
//
	@Test
	public void testCreateAndGetUser(){					
		HttpUser userToSend = new HttpUser();
		userToSend.userID=1;
		userToSend.userName="newName"+Math.random();
		userToSend.password="mypwd";
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(201, response.getStatus());
	}
	@Test
	public void testCreateAndGetUserFail(){					
		HttpUser userToSend = new HttpUser();
		userToSend.userID=1;
		userToSend.password="mypwd";
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(400, response.getStatus());
	}
	
	@Test
	public void testAuthenticateUser(){
		HttpUser userToSend = new HttpUser();
		userToSend.userID=1;
		userToSend.userName="newName";
		userToSend.password="mypwd";
		target = client.target(HTTP_HOST).path(URI_PATH+"/verify");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
		Assert.assertNotEquals(null, "", response);
	}
	
	@Test
	public void testAuthenticateUserFail(){
		HttpUser userToSend = new HttpUser();
		userToSend.userID=14;
		userToSend.userName="newName";
		userToSend.password="mypwd";
		target = client.target(HTTP_HOST).path(URI_PATH+"/verify");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, response.getStatus());
	}
	@Test
	public void testResetCredential(){
		HttpUser userToSend = new HttpUser();
		userToSend.userID=1;
		userToSend.userName="newName";
		userToSend.password="mypwd";
		target = client.target(HTTP_HOST).path(URI_PATH+"/reset");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
		Assert.assertNotEquals(null, "", response);
	}
	
	@Test
	public void testResetCredentialFail(){
		HttpUser userToSend = new HttpUser();
		userToSend.userID=170;
		userToSend.userName="frrr";
		userToSend.password="mypwd";
		target = client.target(HTTP_HOST).path(URI_PATH+"/reset");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(userToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(401, response.getStatus());
	}

}
