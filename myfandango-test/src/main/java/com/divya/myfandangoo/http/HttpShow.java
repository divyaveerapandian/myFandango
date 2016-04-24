package com.divya.myfandangoo.http;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


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
	public HttpMovie movie;

	@XmlElement
	public HttpTheatre theatre;

	
}
