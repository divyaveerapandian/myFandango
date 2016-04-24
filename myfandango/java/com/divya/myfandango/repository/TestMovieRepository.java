package com.divya.myfandango.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.divya.myfandango.entity.Movie;
import com.divya.myfandango.entity.impl.MovieImpl;

@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests  {

	@Autowired
	private MovieRepository movieRepository;

	//	@Rollback(false)
	@Test
	public void testAddmovie(){
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
		int value =movieRepository.add(movie);
		if(value > 0){
			Assert.assertNotEquals(0, value);
		}
	}

	//	@Rollback(false)
	@Test
	public void testListMovie() {
		List<Movie> list = movieRepository.list();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("");
			System.out.println(list.get(i).toString());
		}
		Assert.assertNotEquals(0, list.size());
	}

	//	@Rollback(false)
	@Test
	public void testSortMovie() {
		List<Movie> list = movieRepository.sort();
		for (int i = 0; i < list.size(); i++) {
			System.out.println("");
			System.out.println(list.get(i).toString());
		}
		Assert.assertNotEquals(0, list.size());
	}

	//@Rollback(false)
	@Test
	public void testListMovieInTheatre() {
		int theatreId = 1;
		movieRepository.list(theatreId);
	}
}
