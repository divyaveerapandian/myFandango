package com.divya.myfandangoo.service;

import java.util.List;
import com.divya.myfandangoo.entity.Show;

public interface ShowService {
	List<Show> showsForMovieTheatreCombo(int movieId,int theatreId);
	int scheduleNewShow(Show show);
	void deleteShow(Show show);
	List<Show> get(int movieId, int theatreId);
	boolean getTicket(int showId,int noOfTickets);
}
