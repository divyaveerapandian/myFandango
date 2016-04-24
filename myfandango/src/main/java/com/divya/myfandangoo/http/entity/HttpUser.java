package com.divya.myfandangoo.http.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.divya.myfandangoo.entity.User;
@XmlRootElement(name = "user")
public class HttpUser {

	@XmlElement
	public int userID;

	@XmlElement
	public String userName;

	@XmlElement
	public String password;

	//required by framework
	protected HttpUser() {}

	public HttpUser(User user) {
		this.userID=user.getUserID();
		this.userName=user.getUserName();
		this.password=user.getPassword();
	}
}
