package com.divya.myfandangoo.repository;

import java.util.List;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.Theatre;

public interface ShowRepository {
	List<Show> get(int movieId,int theatreId);
	List<Theatre> getTheatresForMovie(int movieId);
	List<Movie> getMoviesForTheatre (int theatreId);
	int save(Show show);
	void delete(Show show);
	boolean getTicket(Show show,boolean ticketAvailability);
	Show getShow(int showId);

}
