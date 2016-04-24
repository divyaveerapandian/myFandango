package com.divya.myfandangoo.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.TheatreImpl;
import com.divya.myfandangoo.repository.TheatreRepository;

@Repository
public class TheatreRepositoryImpl implements TheatreRepository{

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public int add(Theatre theatre) {
		return (int) sessionFactory.getCurrentSession().save(theatre);
	}
	
	@SuppressWarnings("unchecked")
	public List<Theatre> list() {
		return sessionFactory.getCurrentSession().createCriteria(Theatre.class).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Theatre> list(int location) {
		return (List<Theatre>) sessionFactory.getCurrentSession().createCriteria(TheatreImpl.class)
				.add(Restrictions.eq("theatreLocation", location)).list();
	}
}
