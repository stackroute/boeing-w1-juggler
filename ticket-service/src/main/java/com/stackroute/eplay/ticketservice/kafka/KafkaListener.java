package com.stackroute.eplay.ticketservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.eplay.ticketservice.domain.Movie;
import com.stackroute.eplay.ticketservice.domain.MovieEvent;
import com.stackroute.eplay.ticketservice.domain.Show;

import com.stackroute.eplay.ticketservice.exception.MovieAlreadyExistException;
import com.stackroute.eplay.ticketservice.service.MovieService;

import com.stackroute.eplay.ticketservice.domain.TicketedEvent;
import com.stackroute.eplay.ticketservice.exception.MovieEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.service.MovieEventService;
import com.stackroute.eplay.ticketservice.service.TicketedEventService;

import com.stackroute.eplay.ticketservice.streams.MovieEventStreams;
import com.stackroute.eplay.ticketservice.streams.MovieStreams;
import com.stackroute.eplay.ticketservice.streams.ShowStreams;
import com.stackroute.eplay.ticketservice.streams.TicketedEventStreams;

@EnableBinding({MovieEventStreams.class, TicketedEventStreams.class, MovieStreams.class, ShowStreams.class})
public class KafkaListener {
	
	MovieEventService movieEventService;
	MovieService movieService;
	TicketedEventService ticketedEventService;

	@Autowired
	KafkaListener(MovieEventService movieEventService,MovieService movieService, TicketedEventService ticketedEventService){
		this.movieEventService=movieEventService;
		this.movieService=movieService;
		this.ticketedEventService= ticketedEventService;
	}

	@StreamListener(MovieEventStreams.INPUT)
	public void movieEventPost(@Payload MovieEvent event) {
		try {
			movieEventService.saveMovieEvent(event);
		} catch (MovieEventAlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(event.toString()+" movie");
	}
	@StreamListener(MovieStreams.INPUT)
	public void moviePost(@Payload Movie movie) {
		try {
			movieService.saveMovie(movie);
		} catch (MovieAlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(movie.toString()+" movie");
	}
	
	@StreamListener(ShowStreams.INPUT)
	public void updateMovieEvent(@Payload Show show) {
		System.out.println(show.toString());
		movieEventService.updateMovieEvent(show);
		
	}
	
	@StreamListener(TicketedEventStreams.INPUT)
	public void ticketedEventPost(@Payload TicketedEvent event) {
		try {
			ticketedEventService.saveTicketedEvent(event);
			System.out.println(event.toString());
		}catch (Exception e) {
			
		}
	}
	
	/*@StreamListener(TheatreStreams.INPUT)
	public void UserPost(@Payload Theatre theatre) {
		theatreRepository.save(theatre);
		System.out.println(theatre.toString()+" theatre");
	}*/
	
	/*@StreamListener(MovieStreams.INPUT)
	public void movieEventPost(@Payload Movie movie) {
		movieRepository.save(movie);
		System.out.println(movie.toString()+" movie");
	}*/
}
