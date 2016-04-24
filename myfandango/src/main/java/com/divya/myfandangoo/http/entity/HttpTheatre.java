package com.divya.myfandangoo.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.divya.myfandangoo.entity.Theatre;

@XmlRootElement(name = "theatre")
public class HttpTheatre {

	@XmlElement
	public int theatreId;
	@XmlElement
	public String theatreName;
	@XmlElement
	public int theatreLocation;
	public HttpTheatre(){}
	public HttpTheatre(Theatre theatre) {
		this.theatreId = theatre.getTheatreId();
		this.theatreName = theatre.getTheatreName();
		this.theatreLocation = theatre.getTheatreLocation();
	}
}
