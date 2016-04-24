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

public class TestTheatreResources {

	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "myfandangoo/rest/theatres";

	private Client client = ClientBuilder.newClient();
	private WebTarget target;

	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}

	@Test
	public void testCreateTheatresNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<theatre/>", MediaType.APPLICATION_XML));
		Assert.assertNotEquals(201, response.getStatus());
	}

	@Test
	public void testCreateTheatresNoParamsEntityXml(){					
		HttpTheatre theatreToSend = new HttpTheatre();		
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity(theatreToSend, MediaType.APPLICATION_XML));
		Assert.assertNotEquals(201, response.getStatus());
	}

	@Test
	public void testCreateTheatresNoParamsJson(){					
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{theatre:{}}", MediaType.APPLICATION_JSON));
		Assert.assertNotEquals(201, response.getStatus());
	}

	@Test
	public void testCreateTheatresNoParamsEntityJson(){					
		HttpTheatre theatreToSend = new HttpTheatre();		
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theatreToSend, MediaType.APPLICATION_JSON));
		Assert.assertNotEquals(201, response.getStatus());
	}

	@Test
	public void testCreateAndGetTheatre(){					
		HttpTheatre theatreToSend = new HttpTheatre();
		theatreToSend.theatreId=1;
		theatreToSend.theatreName="BMC";
		theatreToSend.theatreLocation=94040;
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(theatreToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(201, response.getStatus());
	}

	@Test
	public void testGetAllTheatres(){
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotEquals(null, "", responseString);
	}

	@Test
	public void testGetMoviesByTheatre(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/1/movies");
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotEquals(null, "", responseString);
	}
	@Test
	public void testGetTheatresByLocation(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/90404");
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotEquals(null, "", responseString);
	}

}
