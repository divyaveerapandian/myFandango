package com.divya.myfandangoo.repository;
import java.util.List;

import com.divya.myfandangoo.entity.Movie;
public interface MovieRepository {
	List<Movie> list();
	List<Movie> sort();
	int add(Movie movie);
	void update(Movie movie);
	void delete(Movie movie);
}

