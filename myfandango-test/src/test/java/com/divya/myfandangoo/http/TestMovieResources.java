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

public class TestMovieResources {

	private static final String HTTP_HOST = "http://localhost:8080";
	private static final String URI_PATH = "myfandangoo/rest/movies";

	private Client client = ClientBuilder.newClient();
	private WebTarget target;

	@Before
	public void init(){
		target = client.target(HTTP_HOST).path(URI_PATH);
	}

	@Test
	public void testGetMoviesNoParamsJson(){						
		Response response =	target.request().accept(MediaType.APPLICATION_JSON).get();
		Assert.assertNotEquals(201, response.getStatus());
	}

	@Test
	public void testGetMoviesNoParamsXml(){						
		Response response =	target.request().accept(MediaType.APPLICATION_XML).get();
		Assert.assertNotEquals(201, response.getStatus());
	}

	@Test
	public void testCreateMoviesNoParamsXml(){					
		Response response =	target.request().accept(MediaType.APPLICATION_XML).post(Entity.entity("<movie/>", MediaType.APPLICATION_XML));
		Assert.assertEquals(400, response.getStatus());
	}


	//		@Test
	//		public void testCreateMoviesNoParamsJson(){					
	//			Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity("{movie:{}}", MediaType.APPLICATION_JSON));
	//			Assert.assertNotEquals(201, response.getStatus());
	//			System.out.println("4 "+response.getStatus());
	//			
	//		}
	//		
	//		@Test
	//		public void testCreateMoviesNoParamsEntityJson(){					
	//			HttpMovie movieToSend = new HttpMovie();		
	//			Response response =	target.request().accept(MediaType.APPLICATION_JSON).post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
	//			Assert.assertNotEquals(201, response.getStatus());
	//			System.out.println("5 "+response.getStatus());
	//		}

	@Test
	public void testCreateAndGetMovie(){					
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieId=1;
		movieToSend.movieName="The new Movie";
		movieToSend.movieGenre="test";
		movieToSend.releaseDate=new Date();

		Response response =	target.request().accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(movieToSend, MediaType.APPLICATION_JSON));
		Assert.assertEquals(201, response.getStatus());
	}

	@Test
	public void testGetAllMovies() {
//		System.out.println("THIS IS THE TEST OUTPUT");
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		//		ObjectMapper mapper = new ObjectMapper();
		//		 mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
		//		List<HttpMovie> movies = mapper.readValue(responseString,mapper.getTypeFactory().constructCollectionType(List.class, HttpMovie.class));
		//        System.out.println(movies);
		Assert.assertNotEquals(null, "", responseString);
	}
	@Test
	public void testMoviesSortedByreleaseDate(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/releaseDateOrder");
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotEquals(null, "", responseString);
	}

	@Test
	public void testTheatresForMovie(){
		target = client.target(HTTP_HOST).path(URI_PATH+"/1/theatres");
		String responseString = target.request(MediaType.APPLICATION_JSON).get(String.class);
		Assert.assertNotEquals(null, "", responseString);
	}

	@Test
	public void testUpdateMovie(){
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieId=15;
		movieToSend.movieName="The new Movie6666";
		movieToSend.movieGenre="test";
		movieToSend.releaseDate=new Date();
		Response response = target.request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(movieToSend,MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, response.getStatus());
	}
	@Test
	public void testUpdateMovieFail(){
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieId=150;
		movieToSend.movieName="The new Movie6666";
		movieToSend.movieGenre="test";
		movieToSend.releaseDate=new Date();
		Response response = target.request().accept(MediaType.APPLICATION_JSON).put(Entity.entity(movieToSend,MediaType.APPLICATION_JSON));
		Assert.assertEquals(400, response.getStatus());
	}

	@Test
	public void testDeleteMovie(){
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieId=15;
		movieToSend.movieName="The new Movie6666";
		movieToSend.movieGenre="test";
		movieToSend.releaseDate=new Date();
		Response response = target.request().accept(MediaType.APPLICATION_JSON).delete();//(Entity.entity(movieToSend,MediaType.APPLICATION_JSON));
		Assert.assertNotEquals(200, response.getStatus());
	}
	
	@Test
	public void testDeleteMovieFail(){
		HttpMovie movieToSend = new HttpMovie();
		movieToSend.movieId=150;
		movieToSend.movieName="The new Movie6666";
		movieToSend.movieGenre="test";
		movieToSend.releaseDate=new Date();
		Response response = target.request().accept(MediaType.APPLICATION_JSON).delete();//(Entity.entity(movieToSend,MediaType.APPLICATION_JSON));
		Assert.assertEquals(415, response.getStatus());
	}

}
