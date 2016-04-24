package com.divya.myfandangoo.http;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "theatre")
public class HttpTheatre {

	public HttpTheatre() {}
	public HttpTheatre(int theatreId, String theatreName, int theatreLocation) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
	}

	@XmlElement
	public int theatreId;
	@XmlElement
	public String theatreName;
	@XmlElement
	public int theatreLocation;
	@Override
	public String toString() {
		return "HttpUser [theatreId=" + theatreId + ", theatreName=" + theatreName
				+ ", theatreLocation=" + theatreLocation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpTheatre other = (HttpTheatre) obj;
		if (theatreName == null) {
			if (other.theatreName != null)
				return false;
		} else if (!theatreName.equals(other.theatreName))
			return false;
		if (theatreId != other.theatreId)
			return false;
		if (theatreLocation != other.theatreLocation)
			return false;
		return true;
	}
}
