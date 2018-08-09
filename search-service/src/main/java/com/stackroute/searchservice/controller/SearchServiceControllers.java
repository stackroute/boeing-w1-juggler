package com.stackroute.searchservice.controller;

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

import com.stackroute.searchservice.domain.Event;
import com.stackroute.searchservice.domain.Query;
import com.stackroute.searchservice.services.SearchServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class SearchServiceControllers {

	private SearchServiceImpl searchService;
	private Environment env;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public SearchServiceControllers(SearchServiceImpl searchService,Environment env){
		this.searchService = searchService;
		this.env = env;
	}

	public SearchServiceControllers(SearchServiceImpl searchService) {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/{city}")
	public ResponseEntity <?> getEventsBycity(@PathVariable String city) {
		try {
			logger.info("This is an info message");
			return new ResponseEntity<Iterable<Event>> (searchService.getEventsByCity(city),HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("This is an error message");
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
