package com.divya.myfandangoo.entity.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.divya.myfandangoo.entity.User;

@Entity
@Table(name="user")
@XmlRootElement
public class UserImpl implements User {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	@Column
	private String userName;
	@Column
	private String password;
	
	public UserImpl() {
	}
	public String getUserName() {
		return userName;
	}

	
	public int getUserID() {
		return userID;
	}

	
	public String getPassword() {
		return password;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
