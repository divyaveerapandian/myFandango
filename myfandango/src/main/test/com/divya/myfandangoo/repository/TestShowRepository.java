package com.divya.myfandangoo.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.MovieImpl;
import com.divya.myfandangoo.entity.impl.ShowImpl;
import com.divya.myfandangoo.entity.impl.TheatreImpl;
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class TestShowRepository extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ShowRepository showRepository;
	
//	@Rollback(false)
//	@Test
//	public void test() {
//		String mystring = "March 4, 2016";
//		Date thedate = null;
//		try {
//			thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mystring);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		MovieImpl movie = new MovieImpl(2,"ss",thedate,"ss");
//		ShowImpl show = new ShowImpl();
//		show.setShowId(1);
//		show.setMovie(movie);
//		show.setScreenCapacity(20);
//		show.setShowScreenNo(2);
//		show.setShowTicketPrice(10);
//		show.setTicketAvailability(20);
//		Date showTime = thedate;
//		show.setShowTime(showTime);
//		Theatre theatre = new TheatreImpl(2, "SSSSS", 32423);
//		show.setTheatre(theatre);
//		showRepository.save(show);
//	}
	@Rollback(false)
	@Test
	public void get() {
		String mystring = "March 4, 2016";
		Date thedate = null;
		try {
			thedate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(mystring);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MovieImpl movie = new MovieImpl(2,"test",thedate,"test");
		Theatre theatre = new TheatreImpl(2, "testing", 32423);
		ShowImpl show = new ShowImpl(1, thedate, 10, 1, 10, 10, movie, theatre);
		show.setMovie(movie);
		show.setTheatre(theatre);
		List<Show> list = showRepository.get(movie.getMovieId(), theatre.getTheatreId());
		 showRepository.getTheatresForMovie(movie.getMovieId());
		showRepository.delete(show);
		showRepository.save(show);
		System.out.println(list);
	}
}
