package com.divya.myfandangoo.service;
import java.util.List;
import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Theatre;

public interface MovieService {
	int addMovie(Movie movie);
	List<Movie> getAllMovies();
	List<Movie> getMoviesSortedByReleaseDate();
	List<Theatre> getTheatresForMovie(int movieId);
	void updateMovie(Movie movie);
	void deleteMovie(Movie movie);
}
