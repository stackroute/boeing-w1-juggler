package com.stackroute.eplay.ticketservice.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.ticketservice.domain.MovieEvent;
import com.stackroute.eplay.ticketservice.domain.Show;
import com.stackroute.eplay.ticketservice.exception.MovieEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.repositories.MovieEventRepository;


@Service
public class MovieEventServiceImpl implements MovieEventService{
	MovieEventRepository movieEventRepository;

	@Autowired
	public MovieEventServiceImpl(MovieEventRepository movieEventRepository) {
		this.movieEventRepository = movieEventRepository;
	}

	public MovieEvent saveMovieEvent(MovieEvent movieEvent) throws MovieEventAlreadyExistException {
		Iterable<MovieEvent> movies = getAllMovieEvent();
		Iterator<MovieEvent> iterator = movies.iterator();
		
		while (iterator.hasNext()) {
			MovieEvent m = iterator.next();
			if (movieEvent.equals(m)) {
				throw new MovieEventAlreadyExistException("Movie already exists");
			}
		}
		
		return movieEventRepository.save(movieEvent);
	}


	public Iterable<MovieEvent> getAllMovieEvent() {

		return movieEventRepository.findAll();
	}

	
	

}
