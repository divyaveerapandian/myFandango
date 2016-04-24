package com.divya.myfandangoo.http;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class HttpUser {

	@XmlElement
	public long userID;
	
	@XmlElement
	public String userName;
	
	@XmlElement
	public String password;
	
	@Override
	public String toString() {
		return "HttpUser [id=" + userID + ", userName=" + userName
				+ ", password=" + password + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HttpUser other = (HttpUser) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userID != other.userID)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
}
