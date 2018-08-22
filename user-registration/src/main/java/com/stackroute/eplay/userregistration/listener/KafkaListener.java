package com.stackroute.eplay.userregistration.listener;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.userregistration.domain.MovieEvent;
import com.stackroute.eplay.userregistration.domain.RSVPEvent;
import com.stackroute.eplay.userregistration.domain.Registration;
import com.stackroute.eplay.userregistration.domain.Theatre;
import com.stackroute.eplay.userregistration.domain.TicketedEvent;
import com.stackroute.eplay.userregistration.exception.UserNotFoundException;
import com.stackroute.eplay.userregistration.service.RegisterUser;
import com.stackroute.eplay.userregistration.stream.MovieEventStream;
import com.stackroute.eplay.userregistration.stream.RSVPEventStream;
import com.stackroute.eplay.userregistration.stream.TheatreStream;
import com.stackroute.eplay.userregistration.stream.TicketedEventStream;
import com.stackroute.eplay.userregistration.stream.UserRegistrationStream;

@EnableBinding({ TheatreStream.class, RSVPEventStream.class, MovieEventStream.class, TicketedEventStream.class })
public class KafkaListener {

	private RegisterUser registerUser;
	private UserRegistrationStream userRegistrationStream;

	@Autowired
	public KafkaListener(RegisterUser registerUser, UserRegistrationStream userRegistrationStream) {
		this.registerUser = registerUser;
		this.userRegistrationStream = userRegistrationStream;
	}

	@StreamListener(TheatreStream.INPUT)
	public void theatrePost(@Payload Theatre theatre) {
		String userName = theatre.getUserName();
		try {
			Registration user = registerUser.findByUsername(userName);
			System.out.println(user.getUserName() + " " + user.getFullName());
			List<Theatre> theatres;
			if (user.getTheatres() == null)
				theatres = new ArrayList<>();
			else
				theatres = user.getTheatres();
			theatres.add(theatre);
			user.setTheatres(theatres);

			/*
			 * updating the content in database
			 */

			registerUser.updateUser(user, userName);

			/*
			 * putting content in the message bus
			 */

			MessageChannel messageChannel = userRegistrationStream.outboundUserRegistration();
			messageChannel.send(MessageBuilder.withPayload(user)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@StreamListener(RSVPEventStream.INPUT)
	public void rsvpEventPost(@Payload RSVPEvent rsvpEvent) {
		System.out.println(rsvpEvent.toString() + " rsvp event");

		String userName = rsvpEvent.getUserName();
		try {
			Registration user = registerUser.findByUsername(userName);
			System.out.println(user.getUserName() + " " + user.getFullName());
			List<RSVPEvent> rsvpEvents;
			if (user.getRsvpEvents() == null)
				rsvpEvents = new ArrayList<>();
			else
				rsvpEvents = user.getRsvpEvents();
			rsvpEvents.add(rsvpEvent);
			user.setRsvpEvents(rsvpEvents);

			/*
			 * updating the content in database
			 */

			registerUser.updateUser(user, userName);

			/*
			 * putting content in the message bus
			 */

			MessageChannel messageChannel = userRegistrationStream.outboundUserRegistration();
			messageChannel.send(MessageBuilder.withPayload(user)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@StreamListener(TicketedEventStream.INPUT)
	public void ticketedEventPost(@Payload TicketedEvent ticketedEvent) {
		System.out.println(ticketedEvent.toString() + " ticketed event");

		String userName = ticketedEvent.getUserName();
		try {
			Registration user = registerUser.findByUsername(userName);
			System.out.println(user.getUserName() + " " + user.getFullName());
			List<TicketedEvent> ticketedEvents;
			if (user.getTicketedEvent() == null)
				ticketedEvents = new ArrayList<>();
			else
				ticketedEvents = user.getTicketedEvent();
			ticketedEvents.add(ticketedEvent);
			user.setTicketedEvent(ticketedEvents);

			/*
			 * updating the content in database
			 */

			registerUser.updateUser(user, userName);

			/*
			 * putting content in the message bus
			 */

			MessageChannel messageChannel = userRegistrationStream.outboundUserRegistration();
			messageChannel.send(MessageBuilder.withPayload(user)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@StreamListener(MovieEventStream.INPUT)
	public void movieEventPost(@Payload MovieEvent movieEvent) {
		System.out.println(movieEvent.toString() + " movie event");

		String userName = movieEvent.getUserName();
		try {
			Registration user = registerUser.findByUsername(userName);
			System.out.println(user.getUserName() + " " + user.getFullName());
			List<MovieEvent> movieEvents;
			if (user.getTicketedEvent() == null)
				movieEvents = new ArrayList<>();
			else
				movieEvents = user.getMovieEvent();
			movieEvents.add(movieEvent);
			user.setMovieEvent(movieEvents);

			/*
			 * updating the content in database
			 */

			registerUser.updateUser(user, userName);

			/*
			 * putting content in the message bus
			 */

			MessageChannel messageChannel = userRegistrationStream.outboundUserRegistration();
			messageChannel.send(MessageBuilder.withPayload(user)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}