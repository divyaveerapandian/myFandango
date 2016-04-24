package com.divya.myfandangoo.http.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.MovieImpl;
import com.divya.myfandangoo.entity.impl.TheatreImpl;

@XmlRootElement(name = "show")
public class HttpShow {

	@XmlElement
	public int showId;

	@XmlElement
	public Date showTime;

	@XmlElement
	public int showTicketPrice;
	@XmlElement
	public int showScreenNo;

	@XmlElement
	public int ticketAvailability;

	@XmlElement
	public int screenCapacity;



	@XmlElement
	public MovieImpl movie;

	@XmlElement
	public TheatreImpl theatre;

	public HttpShow(){

	}
	//	public HttpShow(int showId, Date showTime, int showTicketPrice, int showScreenNo, int ticketAvailability,
	//			int screenCapacity, Movie movie, Theatre theatre) {
	//		super();
	//		this.showId = showId;
	//		this.showTime = showTime;
	//		this.showTicketPrice = showTicketPrice;
	//		this.showScreenNo = showScreenNo;
	//		this.ticketAvailability = ticketAvailability;
	//		this.screenCapacity = screenCapacity;
	//		this.movie=movie;
	//		this.theatre =theatre;
	//	}
	public HttpShow(Show show) {

		this.showId = show.getShowId();
		this.showTime = show.getShowTime();
		this.showTicketPrice =show.getShowTicketPrice();
		this.showScreenNo =show.getshowScreenNo();
		this.ticketAvailability =show.getTicketAvailability();
		this.screenCapacity =show.getScreencapacity();
		this.movie =(MovieImpl) show.getMovie();
		this.theatre =(TheatreImpl) show.getTheatre();

	}

}
