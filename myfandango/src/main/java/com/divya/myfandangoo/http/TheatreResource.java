package com.divya.myfandangoo.http;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.TheatreImpl;
import com.divya.myfandangoo.http.entity.HttpMovie;
import com.divya.myfandangoo.http.entity.HttpTheatre;
import com.divya.myfandangoo.service.TheatreService;

@Path("theatres")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheatreResource {
	@Autowired
	private TheatreService theatreService;

	@GET
	public List<HttpTheatre> getAllTheatres(){
		List<HttpTheatre> httpTheatres = new ArrayList<>();
		List<Theatre> theatres = theatreService.getTheatres();
		for( Theatre theatre : theatres){
			httpTheatres.add(convert(theatre));
		}
//		return Response.status(Status.OK).entity(httpTheatres)
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//				.allow("OPTIONS").build();
		return httpTheatres;
	}

	@POST
	public Response addTheatre(HttpTheatre httpTheatre){
		if(httpTheatre.theatreLocation <= 0 || httpTheatre.theatreName == null){
			return Response.status(Status.BAD_REQUEST).build();
		}
		Theatre theatre = convert(httpTheatre);
		int theatreId = theatreService.addTheatre(theatre);
		return Response.status(Status.CREATED).header("Location", "/theatres/"+theatreId).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@GET
	@Path("/{threatreLocation}")
	public List<HttpTheatre> getThreatresByLocation(@PathParam("threatreLocation") int threatreLocation){
		List<HttpTheatre> httpTheatres = new ArrayList<>();
		List<Theatre> theatres =  theatreService.getThreatresByLocation(threatreLocation);
		for( Theatre theatre : theatres){
			httpTheatres.add(convert(theatre));
		}
		return httpTheatres;
	}
	@GET
	@Path("/{theatreId}/movies")
	public  List<HttpMovie> getTheatresForMovie(@PathParam("theatreId") int theatreId ) {
		List<HttpMovie> httpMovies = new ArrayList<>();
		List<Movie> movies = theatreService.getMoviesForTheatre(theatreId);
		for( Movie movie : movies){
			MovieResource movieResource=  new MovieResource();
			httpMovies.add(movieResource.convert(movie));
		}
		return httpMovies;
	}

	private Theatre convert(HttpTheatre httpTheatre) {
		TheatreImpl theatre = new TheatreImpl();
		theatre.setTheatreId(httpTheatre.theatreId);
		theatre.setTheatreLocation(httpTheatre.theatreLocation);
		theatre.setTheatreName(httpTheatre.theatreName);
		return theatre;
	}	

	public HttpTheatre convert(Theatre theatre) {
		HttpTheatre httpTheatre = new HttpTheatre(theatre);
		return httpTheatre;
	}	
}
