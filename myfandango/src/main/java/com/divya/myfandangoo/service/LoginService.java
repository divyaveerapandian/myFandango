package com.divya.myfandangoo.service;

import com.divya.myfandangoo.entity.User;

public interface LoginService {
	
	String userAuthentication(String userName, String password);
	
	int createNewUser(User user);
	
	void resetPassword(User user);
	
}
