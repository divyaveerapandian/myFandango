package com.divya.myfandangoo.repository;

import com.divya.myfandangoo.entity.User;

public interface LoginRepository {
	
	int create(User user);
	User verify(String userName,String Password);
	void reset(User user);
}
