/*package com.stackroute.eplay.downstreamservice.listener;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.downstreamservice.domain.Movie;
import com.stackroute.eplay.downstreamservice.domain.MovieEvent;
import com.stackroute.eplay.downstreamservice.domain.RSVPEvent;
import com.stackroute.eplay.downstreamservice.domain.Theatre;
import com.stackroute.eplay.downstreamservice.domain.TicketedEvent;
import com.stackroute.eplay.downstreamservice.domain.User;
import com.stackroute.eplay.downstreamservice.repository.MovieEventRepository;
import com.stackroute.eplay.downstreamservice.repository.MovieRepository;
import com.stackroute.eplay.downstreamservice.repository.RSVPEventRepository;
import com.stackroute.eplay.downstreamservice.repository.TheatreRepository;
import com.stackroute.eplay.downstreamservice.repository.TicketedEventRepository;
import com.stackroute.eplay.downstreamservice.repository.UserRepository;
import com.stackroute.eplay.downstreamservice.stream.MovieEventStreams;
import com.stackroute.eplay.downstreamservice.stream.MovieStreams;
import com.stackroute.eplay.downstreamservice.stream.RSVPEventStreams;
import com.stackroute.eplay.downstreamservice.stream.TheatreStreams;
import com.stackroute.eplay.downstreamservice.stream.TicketedEventStreams;
import com.stackroute.eplay.downstreamservice.stream.UserStreams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DownStreamListenerIT {
	MovieStreams movieStreams;
	MovieEventStreams movieEventStreams;
	TicketedEventStreams ticketedEventStreams;
	TheatreStreams theatreStreams;
	RSVPEventStreams rsvpStreamStreams;
	UserStreams userStreams;
	
	@Autowired
	private MovieEventRepository movieEventRepository;
	@Autowired
	private RSVPEventRepository rsvpEventRepository;
	@Autowired
	private TicketedEventRepository ticketedEventRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TheatreRepository theatreRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	TicketedEvent ticketedEvent;
	MovieEvent movieEvent;
	RSVPEvent rsvpEvent;
	User user;
	Theatre theatre;
	Movie movie;

	@Before
    public void setUp() throws Exception {
        movie = new Movie();
        movie.setId(1);
        
        ticketedEvent = new TicketedEvent();
        ticketedEvent.setId(2);
        
        movieEvent = new MovieEvent();
        movieEvent.setMovieEventId(3);
        
        rsvpEvent = new RSVPEvent();
        rsvpEvent.setId(4);
        
        user = new User();
        user.setUserName("5");
        
        theatre = new Theatre();
        theatre.setTheatreId(6);
        
    }
	
	@After
    public void tearDown() throws Exception {
		movieRepository.delete(movie);
		ticketedEventRepository.delete(ticketedEvent);
		movieEventRepository.delete(movieEvent);
		rsvpEventRepository.delete(rsvpEvent);
		userRepository.delete(user);
		theatreRepository.delete(theatre);
    }

	@Test
	public void saveMovie() throws Exception {
		System.out.println("----------------------------------------------------");
		System.out.println(movie);
		MessageChannel messageChannel = movieStreams.outboundMovie();
		messageChannel.send(MessageBuilder.withPayload(movie)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		assertEquals(movie, movieRepository.findById(1).get());
	}
	
	@Test
	public void saveMovieEvent() throws Exception {
		MessageChannel messageChannel = movieEventStreams.outboundMovieEvent();
		messageChannel.send(MessageBuilder.withPayload(movieEvent)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		assertEquals(movieEvent, movieEventRepository.findById(3).get());
	}
	
	@Test
	public void saveTicketedEvent() throws Exception {
		MessageChannel messageChannel = ticketedEventStreams.outboundTicketedEvent();
		messageChannel.send(MessageBuilder.withPayload(ticketedEvent)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		assertEquals(ticketedEvent, ticketedEventRepository.findById(2).get());
	}
	
	@Test
	public void saveRSVPEvent() throws Exception {
		MessageChannel messageChannel = rsvpStreamStreams.outboundRSVPEvent();
		messageChannel.send(MessageBuilder.withPayload(rsvpEvent)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		assertEquals(rsvpEvent, rsvpEventRepository.findById(4).get());
	}
	
	@Test
	public void saveUser() throws Exception {
		MessageChannel messageChannel = userStreams.outboundUser();
		messageChannel.send(MessageBuilder.withPayload(user)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		assertEquals(user, userRepository.findById("5").get());
	}
	
	@Test
	public void saveTheatre() throws Exception {
		MessageChannel messageChannel = theatreStreams.outboundTheatre();
		messageChannel.send(MessageBuilder.withPayload(theatre)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		assertEquals(theatre, theatreRepository.findById(6).get());
	}
}
*/