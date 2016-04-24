package com.divya.myfandangoo.entity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Show;

@Entity
@Table(name = "movie")
public class MovieImpl implements Movie{

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;

	@Column
	private String movieName;

	@Column
	private Date releaseDate;

	@Column
	private String movieGenre;

	@OneToMany(mappedBy = "movie", targetEntity=ShowImpl.class, cascade=CascadeType.ALL)
	private List<Show> show;
	

	public List<Show> getShow() {
		return show;
	}

	public void setShow(Show show) {
		if(this.show==null){
			this.show = new ArrayList<Show>();
		}
		this.show.add(show);
	}

	public MovieImpl() {}
	
	public MovieImpl(int movieId,String movieName,Date releaseDate,String movieGenre) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.releaseDate = releaseDate;
	}
		
	public int getMovieId() {
		return movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getGenre() {
		return movieGenre;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setGenre(String movieGenre) {
		this.movieGenre=movieGenre;
	}

	public String toString() {
		return "Movie Name: "+movieName+ " Movie Genre: "+movieGenre+" Movie Release Date: "+releaseDate;
	}
}
