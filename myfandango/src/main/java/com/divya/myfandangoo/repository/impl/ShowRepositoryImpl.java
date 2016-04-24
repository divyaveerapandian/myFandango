package com.divya.myfandangoo.repository.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.ShowImpl;
import com.divya.myfandangoo.repository.ShowRepository;

@Repository
public class ShowRepositoryImpl implements ShowRepository {

	@Autowired
	private SessionFactory sessionFactory;
	public void SessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<Show> get(int movieId, int theatreId) {
		return (List<Show>) sessionFactory.getCurrentSession().createCriteria(ShowImpl.class)
				.add(Restrictions.eq("movie.movieId", movieId))
				.add(Restrictions.eq("theatre.theatreId", theatreId)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Theatre> getTheatresForMovie(int movieId) {
		List<Show> showList = (List<Show>)sessionFactory.getCurrentSession().createCriteria(ShowImpl.class)
				.add(Restrictions.eq("movie.movieId", movieId)).list();
		List<Theatre> theatreList = new ArrayList<>();
		for (Show show : showList){
			theatreList.add(show.getTheatre());
		}
		return theatreList;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getMoviesForTheatre (int theatreId) {
		List<Show> showList =(List<Show>) sessionFactory.getCurrentSession().createCriteria(ShowImpl.class)
				.add(Restrictions.eq("theatre.theatreId", theatreId)).list();
		List<Movie> movieList =new ArrayList<>();
		for(Show show : showList){
			movieList.add(show.getMovie());
		}
		return movieList;
	}

	public int save(Show show) {
		return (int) sessionFactory.getCurrentSession().save(show);
	}

	public void delete(Show show) {
		sessionFactory.getCurrentSession().delete(show);
	}


	public Show getShow(int showId) {
		return (Show) sessionFactory.getCurrentSession().get(ShowImpl.class,showId);
	}

	@Override
	public boolean getTicket(Show show,boolean ticketAvailability) {
		if(!ticketAvailability){
			return false;
		}
		sessionFactory.getCurrentSession().update(show);
		return ticketAvailability;
	}
}
