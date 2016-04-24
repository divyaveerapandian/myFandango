package com.divya.myfandangoo.service.impl;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.divya.myfandangoo.entity.User;
import com.divya.myfandangoo.repository.LoginRepository;
import com.divya.myfandangoo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginRepository loginRepository;
	
	@Transactional
	public String userAuthentication(String userName, String password) {
		User user = loginRepository.verify(userName,password);
		if(user != null){
			return "Success";
		}
		return "Failure";
	}

	@Transactional
	public int createNewUser(User user) {
		int value =loginRepository.create(user);
		return value;
	}

	@Transactional
	public void resetPassword(User user) {
		loginRepository.reset(user);
	}

}
