package com.stackroute.eplay.ticketservice.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.ticketservice.domain.Movie;
import com.stackroute.eplay.ticketservice.domain.MovieEvent;
import com.stackroute.eplay.ticketservice.domain.Show;
import com.stackroute.eplay.ticketservice.exception.MovieEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.repositories.MovieEventRepository;
import com.stackroute.eplay.ticketservice.streams.MovieEventStreams;


@Service
public class MovieEventServiceImpl implements MovieEventService{
	MovieEventRepository movieEventRepository;
	MovieEventStreams movieEventStreams;

	public MovieEventServiceImpl(MovieEventRepository movieEventRepository,MovieEventStreams movieEventStreams) {
		this.movieEventRepository = movieEventRepository;
		this.movieEventStreams= movieEventStreams;
	}

	public MovieEvent saveMovieEvent(MovieEvent movieEvent) throws MovieEventAlreadyExistException {
		Iterable<MovieEvent> movies = getAllMovieEvent();
		Iterator<MovieEvent> iterator = movies.iterator();
		
		while (iterator.hasNext()) {
			MovieEvent m = iterator.next();
			if (movieEvent.equals(m)) {
				throw new MovieEventAlreadyExistException("Movie Event already exists");
			}
		}
		
		return movieEventRepository.save(movieEvent);
	}

	


	public Iterable<MovieEvent> getAllMovieEvent() {

		return movieEventRepository.findAll();
	}

	public Optional<MovieEvent> getMovieEventById(int id) {
		return movieEventRepository.findById(id);
	}
	public void updateMovieEvent(Show show) {
		
		MovieEvent movieEvent= getMovieEventById(show.getMovieEventId()).get();
		int showCount=movieEvent.getShowCount()+1;
		movieEvent.setShowCount(showCount);
		List<Show> shows=movieEvent.getShows();
		shows.add(show);
		movieEvent.setShows(shows);
		
		movieEventRepository.save(movieEvent);
		MessageChannel messageChannel = movieEventStreams.outboundMovieEvent();
        messageChannel.send(MessageBuilder.withPayload(movieEvent)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
		
	}

}
