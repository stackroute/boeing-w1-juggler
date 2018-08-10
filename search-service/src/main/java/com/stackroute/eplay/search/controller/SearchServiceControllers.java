package com.stackroute.eplay.search.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.Query;
import com.stackroute.eplay.search.domain.TicketedEvent;
import com.stackroute.eplay.search.services.SearchServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class SearchServiceControllers {

	private SearchServiceImpl searchService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public SearchServiceControllers(SearchServiceImpl searchService){
		this.searchService = searchService;
	}


	@GetMapping("/{city}")
	public ResponseEntity <?> getEventsBycity(@PathVariable String city) {
		try {
			logger.info("Getting events in " + city);
			return new ResponseEntity<Iterable<Movie>> (searchService.getEventsByCity(city),HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("Could not fetch events in " + city);
			return new ResponseEntity <String> (e.getMessage(),HttpStatus.CONFLICT);
		}
	

	}
	@GetMapping("/queries")
	public ResponseEntity <?> getAllQueries() {
		try {
			logger.info("This is an info message");
			return new ResponseEntity<Iterable<Query>> (searchService.getAllQueries(),HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("This is an error message");
			return new ResponseEntity <String> (e.getMessage(),HttpStatus.CONFLICT);
		}
	

	}

}
