package com.divya.myfandangoo.http;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.divya.myfandangoo.entity.Show;
import com.divya.myfandangoo.entity.impl.ShowImpl;
import com.divya.myfandangoo.http.entity.HttpShow;
import com.divya.myfandangoo.service.ShowService;

@Path("shows")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ShowResource {
	@Autowired
	private ShowService showService;

	@POST
	public HttpShow createShow(HttpShow httpShow){
		if(httpShow.movie == null||httpShow.theatre==null||httpShow.showTime==null){
			return null;
		}
		Show show = convert(httpShow);
		showService.scheduleNewShow(show);
		return httpShow;
			
	}

	@DELETE
	public Response deleteShow(HttpShow httpShow){
		Show show = convert(httpShow);
		try{
			showService.deleteShow(show);
			return Response.status(Status.OK).build();
		}catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Wrapped(element="shows")
	@Path("/movie/{movieId}/theatre/{theatreId}")
	public List<HttpShow> getShow(@PathParam("movieId") int movieId,@PathParam("theatreId") int theatreId){
		List<Show> shows =showService.get(movieId, theatreId);
		List<HttpShow> httpShows = new ArrayList<>();
		for( Show show : shows){
			httpShows.add(convert(show));
		}
		return httpShows;
		//		return Response.status(Status.FOUND).entity(httpShows).header("Location", "/shows/").build();
	}
	@PUT
	@Path("{showId}/tickets/{noOfTickets}")
	public Response getTicket(@PathParam("showId") int showId,@PathParam("noOfTickets") int noOfTickets){
		boolean ticketAvailabiliy =showService.getTicket(showId, noOfTickets);
		if(ticketAvailabiliy)
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.CONFLICT).build();
	}

	private Show convert(HttpShow httpShow) {
		ShowImpl show = new ShowImpl();
		show.setScreenCapacity(httpShow.screenCapacity);
		show.setMovie(httpShow.movie);
		show.setTheatre(httpShow.theatre);
		show.setShowId(httpShow.showId);
		show.setShowScreenNo(httpShow.showScreenNo);
		show.setShowTicketPrice(httpShow.showTicketPrice);
		show.setShowTime(httpShow.showTime);
		show.setTicketAvailability(httpShow.ticketAvailability);

		return show;
	}	

	public HttpShow convert(Show show) {
		HttpShow httpShow = new HttpShow(show);
		return httpShow;
	}	
}
