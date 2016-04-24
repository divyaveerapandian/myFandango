package com.divya.myfandangoo.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.Theatre;

//@MappedSuperclass
@Entity
@Table(name="movie_show")
public class ShowImpl implements Show{

	@Id
	@Column(name="showId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	
	@Column
	private Date showTime;
	
	@Column
	private int showTicketPrice;
	
	public ShowImpl(){
		
	}
	
	public ShowImpl(int showId, Date showTime, int showTicketPrice, int showScreenNo, int ticketAvailability,
			int screenCapacity, Movie movie, Theatre theatre) {
		this.showId = showId;
		this.showTime = showTime;
		this.showTicketPrice = showTicketPrice;
		this.showScreenNo = showScreenNo;
		this.ticketAvailability = ticketAvailability;
		this.screenCapacity = screenCapacity;
		this.movie = movie;
		this.theatre = theatre;
	}

	@Column
	private int showScreenNo;
	
	@Column
	private int ticketAvailability;
	
	@Column
	private int screenCapacity;
	

	@ManyToOne(fetch = FetchType.EAGER, targetEntity=MovieImpl.class)
	@JoinColumn(name="movieId")
	private Movie movie;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity=TheatreImpl.class)
	@JoinColumn(name="theatreId")	
	private Theatre theatre;
	
	public int getShowScreenNo() {
		return showScreenNo;
	}

	public void setShowScreenNo(int showScreenNo) {
		this.showScreenNo = showScreenNo;
	}

	public int getScreenCapacity() {
		return screenCapacity;
	}

	public void setScreenCapacity(int screenCapacity) {
		this.screenCapacity = screenCapacity;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}

	public void setShowTicketPrice(int showTicketPrice) {
		this.showTicketPrice = showTicketPrice;
	}

	public void setTicketAvailability(int ticketAvailability) {
		this.ticketAvailability = ticketAvailability;
	}
	
	public int getShowId() {
		return showId;
	}

	public Date getShowTime() {
		return showTime;
	}

	public int getShowTicketPrice() {
		return showTicketPrice;
	}

	public int getshowScreenNo() {
		return showScreenNo;
	}

	public int getTicketAvailability() {
		return ticketAvailability;
	}

	public int getScreencapacity() {
		return screenCapacity;
	}
	


}
