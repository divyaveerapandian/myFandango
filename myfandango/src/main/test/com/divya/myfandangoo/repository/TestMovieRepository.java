package com.divya.myfandangoo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.impl.MovieImpl;
import com.divya.myfandangoo.entity.impl.ShowImpl;
import com.divya.myfandangoo.entity.impl.TheatreImpl;

@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestMovieRepository extends AbstractTransactionalJUnit4SpringContextTests  {

	@Autowired
	private MovieRepository movieRepository;

	//	@Rollback(false)
//	@Test
//	public void testAddmovie(){
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
//		int value =movieRepository.add(movie);
//		if(value > 0){
//			Assert.assertNotEquals(0, value);
//		}
//	}

	//	@Rollback(false)
//	@Test
//	public void testListMovie() {
//		List<Movie> list = movieRepository.list();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("");
//			System.out.println(list.get(i).toString());
//		}
//		Assert.assertNotEquals(0, list.size());
//	}

	//	@Rollback(false)
//	@Test
//	public void testSortMovie() {
//		List<Movie> list = movieRepository.sort();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println("");
//			System.out.println(list.get(i).toString());
//		}
//		Assert.assertNotEquals(0, list.size());
//	}
	
	@Rollback(false)
	@Test
	public void testUpdateMovie() {
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat ( "dd-MMM-yyyy" );

		String dateInString = "06-November-2015";
//		2015-11-06

		java.util.Date dateObject=null;
		try {
			dateObject = dateFormatter.parse ( dateInString );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MovieImpl movie = new MovieImpl(3,"Spotlight",dateObject,"Drama");
		TheatreImpl theatre = new TheatreImpl(1, "AMC", 95002);
		ShowImpl show = new ShowImpl(3,dateObject,10,1,10,10,movie,theatre);
		movie.setShow(show);
		movieRepository.update(movie);
		
	}
}
