package com.divya.myfandangoo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.repository.ShowRepository;
import com.divya.myfandangoo.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	ShowRepository showRepository;

	@Transactional
	public List<Show> showsForMovieTheatreCombo(int movieId, int theatreId) {
		return showRepository.get(movieId, theatreId);
	}

	@Transactional
	public int scheduleNewShow(Show show) {
		return showRepository.save(show);
	}

	@Transactional
	public void deleteShow(Show show) {
		showRepository.delete(show);
	}

	@Transactional
	public List<Show> get(int movieId, int theatreId) {
		return showRepository.get(movieId, theatreId);
	}

	@Transactional
	public boolean getTicket(int showId,int noOfTickets){
		Show show = showRepository.getShow(showId);
		if(show.getTicketAvailability()>=noOfTickets){
			show.setTicketAvailability(show.getTicketAvailability()-noOfTickets);
			return showRepository.getTicket(show,true);
		}
		else{
			return showRepository.getTicket(show,false);
		}

	}
}
