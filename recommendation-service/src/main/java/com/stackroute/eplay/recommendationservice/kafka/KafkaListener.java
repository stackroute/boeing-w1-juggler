package com.stackroute.eplay.recommendationservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.User;
import com.stackroute.eplay.recommendationservice.services.MovieService;
import com.stackroute.eplay.recommendationservice.streams.MovieEventStreams;
import com.stackroute.eplay.recommendationservice.streams.MovieStreams;
import com.stackroute.eplay.recommendationservice.streams.TicketedEventStreams;
import com.stackroute.eplay.recommendationservice.streams.UserStreams;


@EnableBinding({MovieEventStreams.class, TicketedEventStreams.class, MovieStreams.class, UserStreams.class})
public class KafkaListener {
	
	MovieService movieService;
	

	@Autowired
	KafkaListener(MovieService movieEventService,MovieService movieService){
		this.movieService=movieService;
	}

	@StreamListener(MovieEventStreams.INPUT)
	public void movieEventPost(@Payload Movie event) {		
		movieService.saveMovie(event);		
		System.out.println(event.toString()+" movie");
	}
	
	@StreamListener(MovieStreams.INPUT)
	public void moviePost(@Payload Movie movie) {
		movieService.saveMovie(movie);		
		System.out.println(movie.toString()+" movie");
	}
	
	@StreamListener(UserStreams.INPUT)
	public void userPost(@Payload User user) {
		
	}
	}
