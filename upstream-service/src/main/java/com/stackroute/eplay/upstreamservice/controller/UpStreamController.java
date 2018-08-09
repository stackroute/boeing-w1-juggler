package com.stackroute.eplay.upstreamservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.streams.MovieEventStreams;
import com.stackroute.eplay.streams.MovieStreams;
import com.stackroute.eplay.streams.RSVPEventStreams;
import com.stackroute.eplay.streams.TheatreStreams;
import com.stackroute.eplay.streams.TicketedEventStreams;
import com.stackroute.eplay.upstreamservice.domain.Movie;
import com.stackroute.eplay.upstreamservice.domain.MovieEvent;
import com.stackroute.eplay.upstreamservice.domain.RSVPEvent;
import com.stackroute.eplay.upstreamservice.domain.Theatre;
import com.stackroute.eplay.upstreamservice.domain.TicketedEvent;
import com.stackroute.eplay.upstreamservice.service.UpStreamService;

@RestController
@EnableBinding({TicketedEventStreams.class,MovieEventStreams.class,RSVPEventStreams.class,TheatreStreams.class,MovieStreams.class})
@CrossOrigin("*")
@RequestMapping("api/v1/upstream")
public class UpStreamController {

	@Autowired
	private UpStreamService upStreamService;

	@PostMapping("/movieEvent")
	public MovieEvent movie(@RequestBody MovieEvent event) {
		upStreamService.saveMovieEvent(event);
		return event;
	}
	
	@PostMapping("/ticketedEvent")
	public TicketedEvent ticket(@RequestBody TicketedEvent event) {
		upStreamService.saveTicketedEvent(event);
		return event;
	}
	
	@PostMapping("/rsvpEvent")
	public RSVPEvent ticket(@RequestBody RSVPEvent event) {
		upStreamService.saveRSVPEvent(event);
		return event;
	}
	
	@PostMapping("/movie")
	public Movie ticket(@RequestBody Movie event) {
		upStreamService.saveMovie(event);
		return event;
	}
	
	@PostMapping("/theatre")
	public Theatre ticket(@RequestBody Theatre event) {
		upStreamService.saveTheatre(event);
		return event;
	}
	
}
