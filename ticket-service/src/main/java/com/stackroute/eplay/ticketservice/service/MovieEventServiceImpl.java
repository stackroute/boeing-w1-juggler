package com.stackroute.eplay.ticketservice.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
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
import com.stackroute.eplay.ticketservice.repositories.MovieRepository;
import com.stackroute.eplay.ticketservice.streams.MovieEventStreams;
import com.stackroute.eplay.ticketservice.streams.UpdateMovieEventStreams;



@Service
public class MovieEventServiceImpl implements MovieEventService{
	MovieEventRepository movieEventRepository;
	MovieRepository movieRepository;
	MovieEventStreams movieEventStreams;
	UpdateMovieEventStreams updateMovieEventStreams;
	
	@Autowired
	NextSequenceService nextSequenceService;
	@Autowired
	public MovieEventServiceImpl(MovieEventRepository movieEventRepository,MovieEventStreams movieEventStreams,MovieRepository movieRepository,UpdateMovieEventStreams updateMovieEventStreams) {
		this.movieRepository=movieRepository;
		this.movieEventRepository = movieEventRepository;
		this.movieEventStreams= movieEventStreams;
		this.updateMovieEventStreams=updateMovieEventStreams;
	}
	public MovieEventServiceImpl() {}

	public void saveMovieEvent(MovieEvent movieEvent) throws MovieEventAlreadyExistException, ParseException {
		Iterable<MovieEvent> movies = getAllMovieEvent();
		Iterator<MovieEvent> iterator = movies.iterator();
		Movie movie =movieRepository.findById(movieEvent.getMovieId()).get();
		List<Show> shows=new ArrayList<Show>();
		LocalDate releaseDate=movie.getReleaseDate();
	    DateFormat sdf=new SimpleDateFormat("hh:mm");
		String[] showTimes=movieEvent.getShowTimes().split(",");
		int week=movieEvent.getWeek();
		for(int i=0;i<week*2;i++) {
			for(int j=0;j<showTimes.length;j++) {
				Show show=new Show();
				show.setShowId(nextSequenceService.getNextSequence("counter"));
				LocalTime showTime=sdf.parse(showTimes[j].trim()).toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
				show.setStartTime(showTime);
				show.setDate(releaseDate.plusDays(i));
				show.setStatus(true);
				show.setMovieEventId(movieEvent.getMovieEventId());
				shows.add(show);
				
			}
		}
		movieEvent.setShows(shows);
		
		while (iterator.hasNext()) {
			MovieEvent m = iterator.next();
			if (movieEvent.equals(m)) {
				throw new MovieEventAlreadyExistException("Movie Event already exists");
			}
		}
		
	    movieEventRepository.save(movieEvent);
		MessageChannel messageChannel = updateMovieEventStreams.outboundUpdateMovieEvent();
        messageChannel.send(MessageBuilder.withPayload(movieEvent)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
	}

	


	public Iterable<MovieEvent> getAllMovieEvent() {

		return movieEventRepository.findAll();
	}

	public Optional<MovieEvent> getMovieEventById(int id) {
		return movieEventRepository.findById(id);
	}
	public void updateMovieEvent(Show show) {
		
		MovieEvent movieEvent= getMovieEventById(show.getMovieEventId()).get();
		//int showCount=movieEvent.getShowCount()+1;
		//movieEvent.setShowCount(showCount);
		List<Show> shows=movieEvent.getShows();
	
		int showId=show.getShowId();
		Show oldShow = null;
		for(Show showSaved: shows) {
			if(showSaved.getShowId()==showId) {
				oldShow=showSaved;
			}
		}
		
		shows.remove(oldShow);
		shows.add(show);
		movieEvent.setShows(shows);
		
		movieEventRepository.save(movieEvent);
		   movieEventRepository.save(movieEvent);
			MessageChannel messageChannel = updateMovieEventStreams.outboundUpdateMovieEvent();
	        messageChannel.send(MessageBuilder.withPayload(movieEvent)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
		
	}

}
