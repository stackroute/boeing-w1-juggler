package com.stackroute.eplay.upstreamservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import com.stackroute.eplay.streams.MovieEventStreams;
import com.stackroute.eplay.streams.MovieStreams;
import com.stackroute.eplay.streams.RSVPEventStreams;
import com.stackroute.eplay.streams.TheatreStreams;
import com.stackroute.eplay.streams.TicketedEventStreams;
import com.stackroute.eplay.upstreamservice.domain.Movie;
import com.stackroute.eplay.upstreamservice.domain.MovieEvent;
import com.stackroute.eplay.upstreamservice.domain.RSVPEvent;
import com.stackroute.eplay.upstreamservice.domain.Show;
import com.stackroute.eplay.upstreamservice.domain.Theatre;
import com.stackroute.eplay.upstreamservice.domain.TicketedEvent;

@Service
public class UpStreamServiceImpl implements UpStreamService{
	
	private final MovieEventStreams movieEventStream;
	private final RSVPEventStreams rsvpEventStream;
	private final TicketedEventStreams ticketedEventStream;
	private final TheatreStreams theatreStream;
	private final MovieStreams movieStream;
	@Autowired
	private NextSequenceService nextSequenceService;
	
	public UpStreamServiceImpl(MovieEventStreams movieEventStreams,RSVPEventStreams rsvpEventStreams,TicketedEventStreams ticketedEventStreams, TheatreStreams theatreStreams, MovieStreams movieStreams) {
		this.movieEventStream = movieEventStreams;
		this.rsvpEventStream= rsvpEventStreams;
		this.ticketedEventStream= ticketedEventStreams;
		this.theatreStream= theatreStreams;
		this.movieStream= movieStreams;
	}
	

	@Override
	public void saveMovieEvent(MovieEvent event){
		event.setMovieEventId(nextSequenceService.getNextSequence("counter"));
		
		for(Show show: event.getShows()) {
            show.setShowId(nextSequenceService.getNextSequence("counter"));
        }
		MessageChannel messageChannel = movieEventStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
	
	@Override
	public void saveTicketedEvent(TicketedEvent event) {
		event.setId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = ticketedEventStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
	
	@Override
	public void saveRSVPEvent(RSVPEvent event) {
		event.setId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = rsvpEventStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}


	@Override
	public void saveMovie(Movie event) {
		event.setId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = movieStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());	
	}


	@Override
	public void saveTheatre(Theatre event) {
		event.setTheatreId(nextSequenceService.getNextSequence("counter"));
		
		MessageChannel messageChannel = theatreStream.outboundEvents();
		messageChannel.send(MessageBuilder.withPayload(event)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
	

}
