package com.divya.myfandangoo.http;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movie")
public class HttpMovie {
	
	public HttpMovie(){}
	public HttpMovie(int movieId, String movieName, Date releaseDate, String movieGenre) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.movieGenre = movieGenre;
	}

	@XmlElement
	public int movieId;

	@XmlElement
	public String movieName;

	@XmlElement
	public Date releaseDate;

	@XmlElement
	public String movieGenre;
	
	@Override
	public String toString() {
		return "HttpUser [movieId=" + movieId + ", movieName=" + movieName
				+ ", releaseDate=" + releaseDate + ", movieGenre=" + movieGenre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpMovie other = (HttpMovie) obj;
		if (movieName == null) {
			if (other.movieName != null)
				return false;
		} else if (!movieName.equals(other.movieName))
			return false;
		if (movieId != other.movieId)
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (movieGenre == null) {
			if (other.movieGenre != null)
				return false;
		} else if (!movieGenre.equals(other.movieGenre))
			return false;
		return true;
	}
}
