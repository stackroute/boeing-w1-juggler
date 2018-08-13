package com.stackroute.eplay.upstreamservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.upstreamservice.domain.Movie;
import com.stackroute.eplay.upstreamservice.domain.MovieEvent;
import com.stackroute.eplay.upstreamservice.domain.RSVPEvent;
import com.stackroute.eplay.upstreamservice.domain.Show;
import com.stackroute.eplay.upstreamservice.domain.Theatre;
import com.stackroute.eplay.upstreamservice.domain.TicketedEvent;
import com.stackroute.eplay.upstreamservice.streams.MovieEventStreams;
import com.stackroute.eplay.upstreamservice.streams.MovieStreams;
import com.stackroute.eplay.upstreamservice.streams.RSVPEventStreams;
import com.stackroute.eplay.upstreamservice.streams.ShowStreams;
import com.stackroute.eplay.upstreamservice.streams.TheatreStreams;
import com.stackroute.eplay.upstreamservice.streams.TicketedEventStreams;

@Service
public class UpStreamServiceImpl implements UpStreamService{
	
	private final MovieEventStreams movieEventStream;
	private final RSVPEventStreams rsvpEventStream;
	private final TicketedEventStreams ticketedEventStream;
	private final TheatreStreams theatreStream;
	private final MovieStreams movieStream;
	private final ShowStreams showStream;
	@Autowired
	private NextSequenceService nextSequenceService;
	
	// Parameterized Constructor
	public UpStreamServiceImpl(MovieEventStreams movieEventStreams,RSVPEventStreams rsvpEventStreams,TicketedEventStreams ticketedEventStreams, TheatreStreams theatreStreams, MovieStreams movieStreams,ShowStreams showStreams) {
		this.movieEventStream = movieEventStreams;
		this.rsvpEventStream= rsvpEventStreams;
		this.ticketedEventStream= ticketedEventStreams;
		this.theatreStream= theatreStreams;
		this.movieStream= movieStreams;
		this.showStream= showStreams;
	}
	
	// Function for posting Movie event to the Message bus
	@Override
	public void saveMovieEvent(MovieEvent event){
		// Set MovieEventId 
		event.setMovieEventId(nextSequenceService.getNextSequence("counter"));
		
		// Set ShowId for each show in a movie event
		for(Show show: event.getShows()) {
            show.setShowId(nextSequenceService.getNextSequence("counter"));
            show.setMovieEventId(event.getMovieEventId());
        }
		
		System.out.println(event.toString());
		MessageChannel messageChannel = movieEventStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
	
	// Function for posting Ticketed event to the Message bus
	@Override
	public void saveTicketedEvent(TicketedEvent event) {
		// Set Ticket event Id
		event.setId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = ticketedEventStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
	
	// Function for posting RSVP event to the Message bus
	@Override
	public void saveRSVPEvent(RSVPEvent event) {
		//Set RSVP event Id
		event.setId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = rsvpEventStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

	// Function for posting Movie to the Message bus
	@Override
	public void saveMovie(Movie event) {
		//Set Movie Id
		event.setId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = movieStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());	
	}

	// Function for posting Theater to the Message bus
	@Override
	public void saveTheatre(Theatre event) {
		// Set Theatre Id
		event.setTheatreId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = theatreStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}

	// Function for posting Show to the Message bus
	@Override
	public void saveShow(Show event) {
		// Set show Id
		event.setShowId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = showStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
	
}
