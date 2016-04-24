package com.divya.myfandangoo.repository.impl;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divya.myfandangoo.entity.User;
import com.divya.myfandangoo.entity.impl.UserImpl;
import com.divya.myfandangoo.repository.LoginRepository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@Autowired
	private SessionFactory sessionFactory ;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;	
	}

	public User verify(String userName,String password) {
		User user ;
		try{
			user = (User) this.sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("userName", userName)).add(Restrictions.eq("password", password)).list().get(0);
		}catch(Exception e){
			return null;
		}
		return user;
	}

	public int create(User user) {
		return (int) sessionFactory.getCurrentSession().save(user);
	}

	public void reset(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

}
