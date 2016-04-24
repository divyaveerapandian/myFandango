package com.divya.myfandango.service;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.divya.myfandango.entity.impl.MovieImpl;
import com.divya.myfandango.service.MovieService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MovieService movieService;

	@Test
	public void testGetAllMovies(){
		int count = movieService.getAllMovies().size();
		assertEquals(2,count);
	}

//	@Test
//	public void testGetMoviesByTheatre(){
//		String mName = movieService.getMoviesByTheatre(1).get(0).getMovieName();
//		System.out.println(mName);
////		Assert.assertEquals();
//	}
	
	@Test
	public void testGetMoviesSortedByReleaseDate(){
		int size = movieService.getMoviesSortedByReleaseDate().size();
		assertEquals(size,3);
	}
	
	@Test
	public void testAddMovie(){
		MovieImpl movie = new MovieImpl();
		movie.setMovieId(4);
		movie.setMovieName("Whiskey Tango Foxtrot");
		movie.setGenre("Comedy, War");
		String mystring = "March 4, 2016";
		Date thedate = null;
		try {
			thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mystring);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		movie.setReleaseDate(thedate);
		int value = movieService.addMovie(movie);
		assertEquals(value,3);
	}

}
