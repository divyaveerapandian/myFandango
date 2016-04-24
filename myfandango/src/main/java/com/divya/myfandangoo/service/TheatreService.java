package com.divya.myfandangoo.service;

import java.util.List;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Theatre;

public interface TheatreService {
	
	int addTheatre(Theatre theatre);
	List<Theatre> getTheatres();
	List<Theatre> getThreatresByLocation(int threatreLocation);
	List<Movie> getMoviesForTheatre(int theatreId);
}
