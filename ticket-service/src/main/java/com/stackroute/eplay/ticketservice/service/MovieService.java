package com.stackroute.eplay.ticketservice.service;

import com.stackroute.eplay.ticketservice.domain.Movie;
import com.stackroute.eplay.ticketservice.exception.MovieAlreadyExistException;


public interface MovieService {
	public Movie saveMovie(Movie movie) throws MovieAlreadyExistException;
	public Iterable<Movie> getAllMovie();
}
