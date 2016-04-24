package com.divya.myfandangoo.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.repository.MovieRepository;
import com.divya.myfandangoo.repository.ShowRepository;
import com.divya.myfandangoo.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	List<Movie> movieList = null;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ShowRepository showRepository;

	@Transactional
	public int addMovie(Movie movie) {
		if(movie.getMovieName() ==null ||movie.getReleaseDate()==null 
				|| movie.getGenre()==null){
			return 0;
		}
		return movieRepository.add(movie);
	}

	@Transactional
	public List<Movie> getAllMovies() {
		return movieRepository.list();
	}

	@Transactional
	public List<Theatre> getTheatresForMovie(int movieId) {
		return showRepository.getTheatresForMovie(movieId);
	} 

	@Transactional
	public List<Movie> getMoviesSortedByReleaseDate() {
		return movieRepository.sort();
	}

	@Transactional
	public void updateMovie(Movie movie) {
		movieRepository.update(movie);
	}

	@Transactional
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}
}
