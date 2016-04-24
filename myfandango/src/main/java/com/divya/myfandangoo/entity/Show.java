package com.divya.myfandangoo.entity;

import java.util.Date;

public interface Show {
	
	int getShowId();
	
	Date getShowTime();
	
	int getShowTicketPrice();
	
	int getshowScreenNo();
	
	int getTicketAvailability();
	
	int getScreencapacity();
	
	Movie getMovie();
	
	Theatre getTheatre();
	
	void setTicketAvailability(int ticketAvailability);
	
}
