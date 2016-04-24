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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divya.myfandangoo.entity.Movie;
import com.divya.myfandangoo.entity.Theatre;
import com.divya.myfandangoo.entity.impl.MovieImpl;
import com.divya.myfandangoo.http.entity.HttpMovie;
import com.divya.myfandangoo.http.entity.HttpTheatre;
import com.divya.myfandangoo.service.MovieService;

@Path("movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieResource  {

	@Autowired
	private MovieService movieService;

	//		@GET
	//		public Response getAllMovies(){
	//			List<HttpMovie> httpmovies = new ArrayList<>();
	//			List<Movie> movies = movieService.getAllMovies();
	//			for( Movie movie : movies){
	//				httpmovies.add(convert(movie));
	//			}
	//			return Response.status(Status.OK).entity(httpmovies)
	//					.header("Access-Control-Allow-Origin", "*")
	//					.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
	//					.allow("OPTIONS").build();
	//		}
	@GET
	public List<HttpMovie> getAllMovies(){
		List<HttpMovie> httpmovies = new ArrayList<>();
		List<Movie> movies = movieService.getAllMovies();
		for( Movie movie : movies){
			httpmovies.add(convert(movie));
		}
		return httpmovies;
	}

	@POST
	public Response addMovie(HttpMovie httpMovie){
		Movie movie = convert(httpMovie);
		int movieID = movieService.addMovie(movie);
		if(movieID > 0){
			return Response.status(Status.CREATED).header("Location", "/movies/"+movieID).build();
		}
		else{
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@GET
	@Path("/releaseDateOrder")
	public  List<HttpMovie> getMoviesSortedByReleaseDate() {
		List<HttpMovie> httpmovies = new ArrayList<>();
		List<Movie> movies = movieService.getMoviesSortedByReleaseDate();
		for( Movie movie : movies){
			httpmovies.add(convert(movie));
		}
		//		return Response.status(Status.OK).entity(httpmovies)
		//				.header("Access-Control-Allow-Origin", "*")
		//				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
		//				.allow("OPTIONS").build();
		return httpmovies;
	}

	@GET
	@Path("/{movieId}/theatres")
	public  List<HttpTheatre> getTheatresForMovie(@PathParam("movieId") int movieId ) {
		List<HttpTheatre> httpTheatres = new ArrayList<>();
		List<Theatre> theatres = movieService.getTheatresForMovie(movieId);
		for( Theatre theatre : theatres){
			TheatreResource theatreResource=  new TheatreResource();
			httpTheatres.add(theatreResource.convert(theatre));
		}
		return httpTheatres;
	}

	@PUT
	public  Response updateMovie(HttpMovie httpMovie) {
		try{
			Movie movie = convert(httpMovie);
			movieService.updateMovie(movie);
			return Response.status(Status.OK).build();
		}
		catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}

	@DELETE
	public  Response deleteMovie(HttpMovie httpMovie) {
		try{
			Movie movie = convert(httpMovie);
			movieService.deleteMovie(movie);
			return Response.status(Status.OK).build();
		}
		catch(Exception e){
			return Response.status(Status.BAD_REQUEST).build();
		}
	}


	private Movie convert(HttpMovie httpMovie) {
		MovieImpl movie = new MovieImpl();
		movie.setMovieName(httpMovie.movieName);
		movie.setGenre(httpMovie.movieGenre);
		movie.setMovieId(httpMovie.movieId);
		movie.setReleaseDate(httpMovie.releaseDate);
		return movie;
	}	
	public HttpMovie convert(Movie movie) {
		HttpMovie httpMovie = new HttpMovie(movie);
		return httpMovie;
	}	
}
