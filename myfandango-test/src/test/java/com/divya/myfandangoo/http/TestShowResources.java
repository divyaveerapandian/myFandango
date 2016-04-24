package com.divya.myfandangoo.http;

import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestShowResources {

	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "myfandangoo/rest/shows";

	private Client client = ClientBuilder.newClient();
	private WebTarget target;

	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}
	@Test
	public void testCreateShow(){
		HttpShow showToSend = new HttpShow();
		showToSend.showId=1;
		showToSend.showScreenNo=4;
		showToSend.showTicketPrice=10;
		showToSend.showTime=new Date();
		showToSend.screenCapacity=10;
		showToSend.ticketAvailability=10;
		showToSend.movie= new HttpMovie(2,"MovieName123",new Date(),"Action");
		showToSend.theatre = new HttpTheatre(3,"Theatre123",98070);
		Response response =	target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(showToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, response.getStatus());
	}
	

	@Test
	public void testDeleteShow() {
		HttpShow showToSend = new HttpShow();
		showToSend.showId=23;
		showToSend.showScreenNo=4;
		showToSend.showTicketPrice=10;
		showToSend.showTime=new Date();
		showToSend.screenCapacity=10;
		showToSend.ticketAvailability=10;
		showToSend.movie= new HttpMovie(2,"MovieName123",new Date(),"Action");
		showToSend.theatre = new HttpTheatre(3,"Theatre123",98070);
		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.build("DELETE", Entity.entity(showToSend, MediaType.APPLICATION_JSON)).invoke();//(Entity.entity(showToSend,MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testDeleteShowWithWrongID() {
		HttpShow showToSend = new HttpShow();
		showToSend.showId=50;
		showToSend.showScreenNo=4;
		showToSend.showTicketPrice=10;
		showToSend.showTime=new Date();
		showToSend.screenCapacity=10;
		showToSend.ticketAvailability=10;
		showToSend.movie= new HttpMovie(2,"MovieName123",new Date(),"Action");
		showToSend.theatre = new HttpTheatre(3,"Theatre123",98070);
		Response response = target.request().accept(MediaType.APPLICATION_JSON)
				.build("DELETE", Entity.entity(showToSend, MediaType.APPLICATION_JSON)).invoke();
//(Entity.entity(movieToSend,MediaType.APPLICATION_JSON));
		Assert.assertEquals(400, response.getStatus());
	}
	
	@Test
	public void testGetShow(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/movie/2/theatre/1");
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotEquals(null, "", responseString);
	}
	
	@Test
	public void testGetTicket(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/10/tickets/2");
		Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.entity(null,MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testGetTicketWithExcessTickets(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/10/tickets/20");
		Response response = target.request(MediaType.APPLICATION_JSON).put(Entity.entity(null,MediaType.APPLICATION_JSON));
		Assert.assertEquals(409, response.getStatus());
	}
	

}
