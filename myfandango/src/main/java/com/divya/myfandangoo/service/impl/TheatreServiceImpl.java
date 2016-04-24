package com.divya.myfandangoo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.repository.ShowRepository;
import com.divya.myfandangoo.repository.TheatreRepository;
import com.divya.myfandangoo.service.TheatreService;

@Service
public class TheatreServiceImpl implements TheatreService {

	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired
	private ShowRepository showRepository;

	@Transactional
	public int addTheatre(Theatre theatre) {
		if(theatre.getTheatreLocation() <= 0 || theatre.getTheatreName()==null){
			return 0;
		}
		return theatreRepository.add(theatre);
	}
	
	@Transactional
	public List<Theatre> getTheatres() {
		return theatreRepository.list();
	}
	
	@Transactional
	public List<Theatre> getThreatresByLocation(int threatreLocation) {
		return theatreRepository.list(threatreLocation);
	}

	@Transactional
	public List<Theatre> getTheatreByMovies(Movie movie) {
		return null;//showRepository.getTheatres(movie);
	}
	
	@Transactional
	public List<Movie> getMoviesForTheatre(int theatreId) {
		return showRepository.getMoviesForTheatre(theatreId);
	}

}
