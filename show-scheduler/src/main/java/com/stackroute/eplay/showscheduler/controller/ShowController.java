package com.stackroute.eplay.showscheduler.controller;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.showscheduler.domain.MovieEvent;
import com.stackroute.eplay.showscheduler.trigger.ShowTrigger;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ShowController {

	private ShowTrigger showTrigger;

	@Autowired
	public ShowController(ShowTrigger showTrigger) {
		super();
		this.showTrigger = showTrigger;
	}

	@PostMapping("/showScheduler")
	public ResponseEntity<?> saveMovieEvent(@RequestBody MovieEvent movieEvent) throws SchedulerException {
		showTrigger.trigger(movieEvent);
		return new ResponseEntity<MovieEvent>(movieEvent, HttpStatus.CREATED);
	}

}
