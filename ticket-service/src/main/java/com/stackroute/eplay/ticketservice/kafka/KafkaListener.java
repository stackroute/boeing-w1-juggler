package com.stackroute.eplay.ticketservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.eplay.ticketservice.domain.Movie;
import com.stackroute.eplay.ticketservice.domain.MovieEvent;
import com.stackroute.eplay.ticketservice.domain.Show;
import com.stackroute.eplay.ticketservice.exception.MovieAlreadyExistException;
import com.stackroute.eplay.ticketservice.exception.MovieEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.service.MovieEventService;
import com.stackroute.eplay.ticketservice.service.MovieService;
import com.stackroute.eplay.ticketservice.streams.MovieEventStreams;
import com.stackroute.eplay.ticketservice.streams.MovieStreams;
import com.stackroute.eplay.ticketservice.streams.ShowStreams;
import com.stackroute.eplay.ticketservice.streams.TicketedEventStreams;

@EnableBinding({MovieEventStreams.class, TicketedEventStreams.class, MovieStreams.class, ShowStreams.class})
public class KafkaListener {
	
	MovieEventService movieEventService;
	MovieService movieService;

	@Autowired
	KafkaListener(MovieEventService movieEventService,MovieService movieService){
		this.movieEventService=movieEventService;
		this.movieService=movieService;
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
	
	
}
