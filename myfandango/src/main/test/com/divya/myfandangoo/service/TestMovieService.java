package com.divya.myfandangoo.service;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.service.MovieService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MovieService movieService;

//	@Test
//	public void testGetAllMovies(){
//		int count = movieService.getAllMovies().size();
//		assertEquals(2,count);
//	}

	@Test
	public void testGetMoviesByTheatre(){
		int movieId = 1;
		List<Theatre> mName = movieService.getTheatresForMovie(movieId);
		System.out.println(mName);
	}
	
//	@Test
//	public void testGetMoviesSortedByReleaseDate(){
//		int size = movieService.getMoviesSortedByReleaseDate().size();
//		assertEquals(size,3);
//	}
//	
//	@Test
//	public void testAddMovie(){
//		MovieImpl movie = new MovieImpl();
//		movie.setMovieId(4);
//		movie.setMovieName("Whiskey Tango Foxtrot");
//		movie.setGenre("Comedy, War");
//		String mystring = "March 4, 2016";
//		Date thedate = null;
//		try {
//			thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mystring);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		movie.setReleaseDate(thedate);
//		int value = movieService.addMovie(movie);
//		assertEquals(value,3);
//	}

}
