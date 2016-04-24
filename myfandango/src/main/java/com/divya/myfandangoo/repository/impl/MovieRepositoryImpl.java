package com.divya.myfandangoo.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.impl.MovieImpl;
import com.divya.myfandangoo.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	private SessionFactory sessionFactory ;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;	
	}

	@SuppressWarnings("unchecked")
	public List<Movie> list() {
		return sessionFactory.getCurrentSession().createCriteria(MovieImpl.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<Movie> sort() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MovieImpl.class);
		return (List<Movie>) criteria.addOrder(Order.desc("releaseDate")).list();
	}

	public int add(Movie movie) {
		return (int) sessionFactory.getCurrentSession().save(movie);
	}

	public void update(Movie movie) {
		sessionFactory.getCurrentSession().update(movie);
	}
	public void delete(Movie movie) {
		sessionFactory.getCurrentSession().delete(movie);
	}


}
