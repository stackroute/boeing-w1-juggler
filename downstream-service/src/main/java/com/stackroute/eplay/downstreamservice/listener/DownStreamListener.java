package com.stackroute.eplay.downstreamservice.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.downstreamservice.domain.MovieEvent;
import com.stackroute.eplay.downstreamservice.domain.RSVPEvent;
import com.stackroute.eplay.downstreamservice.domain.Theatre;
import com.stackroute.eplay.downstreamservice.domain.TicketedEvent;
import com.stackroute.eplay.downstreamservice.domain.User;
import com.stackroute.eplay.downstreamservice.repository.MovieEventRepository;
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

@EnableBinding({MovieEventStreams.class, TicketedEventStreams.class, RSVPEventStreams.class, MovieStreams.class, TheatreStreams.class, UserStreams.class})
public class DownStreamListener {
	
	private MovieEventRepository movieEventRepository;
	private RSVPEventRepository rsvpEventRepository;
	private TicketedEventRepository ticketedEventRepository;
	private UserRepository userRepository;
	private TheatreRepository theatreRepository;
	
	@Autowired
	public DownStreamListener(MovieEventRepository movieEventRepository,RSVPEventRepository rsvpEventRepository, TicketedEventRepository ticketedEventRepository, TheatreRepository theatreRepository){
		this.movieEventRepository = movieEventRepository;
		this.rsvpEventRepository = rsvpEventRepository;
		this.ticketedEventRepository = ticketedEventRepository;
		this.theatreRepository = theatreRepository;
	}

	@StreamListener(MovieEventStreams.INPUT)
	public void movieEventPost(@Payload MovieEvent event) {
		movieEventRepository.save(event);
		System.out.println(event.toString()+" movie");
	}
	
	@StreamListener(TicketedEventStreams.INPUT)
	public void ticketedEventPost(@Payload TicketedEvent event) {
		ticketedEventRepository.save(event);
		System.out.println(event.toString()+" ticketedmovie");
	}
	
	@StreamListener(RSVPEventStreams.INPUT)
	public void rsvpEventPost(@Payload RSVPEvent event) {
		rsvpEventRepository.save(event);
		System.out.println(event.toString()+" movieevent");
	}
	
	@StreamListener(UserStreams.INPUT)
	public void UserPost(@Payload User user) {
		userRepository.save(user);
		System.out.println(user.getFullName()+" user");
	}
	
	@StreamListener(TheatreStreams.INPUT)
	public void UserPost(@Payload Theatre theatre) {
		theatreRepository.save(theatre);
		System.out.println(theatre.toString()+" theatre");
	}
	
}
