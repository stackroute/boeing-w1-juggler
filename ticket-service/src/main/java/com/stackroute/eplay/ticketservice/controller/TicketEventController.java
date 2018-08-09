package com.stackroute.eplay.ticketservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.ticketservice.domain.MovieEvent;
import com.stackroute.eplay.ticketservice.domain.TicketedEvent;
import com.stackroute.eplay.ticketservice.exception.MovieEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.exception.TicketedEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.service.MovieEventService;
import com.stackroute.eplay.ticketservice.service.TicketedEventService;
import com.stackroute.eplay.ticketservice.streams.MovieEventStreams;
import com.stackroute.eplay.ticketservice.streams.MovieStreams;
import com.stackroute.eplay.ticketservice.streams.TicketedEventStreams;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("api/v1")
@EnableBinding({MovieEventStreams.class, TicketedEventStreams.class, MovieStreams.class})
public class TicketEventController {
	@Autowired
	Environment env;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	MovieEventService movieEventService;
	TicketedEventService ticketedEventService;

	@Autowired
	TicketEventController(MovieEventService movieEventService, TicketedEventService ticketedEventService){
		this.movieEventService=movieEventService;
		this.ticketedEventService = ticketedEventService;
	}

	@PostMapping("/saveMovieEvent")
	public ResponseEntity<?> saveMovieEvent(@RequestBody MovieEvent movieEvent){
		try {
			    logger.debug("This is a debug message");
		        logger.info("This is an info message");
		        logger.warn("This is a warn message");
		    
		        //Environment variable property//
			    //System.out.println( env.getProperty("com.stackroute.username"));
			    movieEventService.saveMovieEvent(movieEvent);
		    	return new ResponseEntity<MovieEvent> (movieEvent,HttpStatus.CREATED);
		    }
		 catch(MovieEventAlreadyExistException e){
			 logger.error("This is an MovieAlreadyExistsException error");
	         return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
	     }
	    
	}
	 @GetMapping("/getAllMovies")
	public ResponseEntity<?> getAllMovieEvent(){
	    	return new ResponseEntity<Iterable<MovieEvent>> (movieEventService.getAllMovieEvent(),HttpStatus.OK);
	    }
	 
	 @PostMapping("/saveTicketedEvent")
	 public ResponseEntity<?> saveTicketedEvent(@RequestBody TicketedEvent ticketedEvent){
		 try {
			 ticketedEventService.saveTicketedEvent(ticketedEvent);
			 return new ResponseEntity<TicketedEvent> (ticketedEvent,HttpStatus.CREATED);
		 }catch(TicketedEventAlreadyExistException e) {
			 return new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
		 }
	 }
	 
	@GetMapping("/getAllTicketedEvent")
	public ResponseEntity<?> getAllTicketedEvent(){
		return new ResponseEntity<Iterable<TicketedEvent>>(ticketedEventService.getAllTicketedEvent(),HttpStatus.OK);
	}
	
	@GetMapping("/getTicketedEventById/{id}")
	public ResponseEntity<?> getTicketedEventById(@PathVariable int id){
		return new ResponseEntity<TicketedEvent>(ticketedEventService.getTicketedEventById(id),HttpStatus.OK);
	}
}

