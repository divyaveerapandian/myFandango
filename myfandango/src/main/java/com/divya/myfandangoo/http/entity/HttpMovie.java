package com.divya.myfandangoo.http.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.divya.myfandangoo.entity.Movie;

@XmlRootElement(name = "movie")
public class HttpMovie {
	public HttpMovie(){
		
	}
	public HttpMovie(Movie movie) {
		this.movieId = movie.getMovieId();
		this.movieName = movie.getMovieName();
		this.releaseDate = movie.getReleaseDate();
		this.movieGenre = movie.getGenre();
	}

	@XmlElement
	public int movieId;

	@XmlElement
	public String movieName;

	@XmlElement
	public Date releaseDate;

	@XmlElement
	public String movieGenre;
}
