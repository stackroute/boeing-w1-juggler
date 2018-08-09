package com.stackroute.eplay.ticketservice.service;

import com.stackroute.eplay.ticketservice.domain.MovieEvent;
import com.stackroute.eplay.ticketservice.domain.Show;
import com.stackroute.eplay.ticketservice.exception.MovieEventAlreadyExistException;

public interface MovieEventService {
	public MovieEvent saveMovieEvent(MovieEvent movieEvent) throws MovieEventAlreadyExistException;
	public Iterable<MovieEvent> getAllMovieEvent();
	public void updateMovieEvent(Show show);

}
