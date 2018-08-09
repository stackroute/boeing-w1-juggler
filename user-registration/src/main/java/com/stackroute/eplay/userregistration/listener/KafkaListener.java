package com.stackroute.eplay.userregistration.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.userregistration.domain.RSVPEvent;
import com.stackroute.eplay.userregistration.domain.Theatre;
import com.stackroute.eplay.userregistration.domain.User;
import com.stackroute.eplay.userregistration.exception.UserNotFoundException;
import com.stackroute.eplay.userregistration.service.UserService;
import com.stackroute.eplay.userregistration.stream.RSVPEventStream;
import com.stackroute.eplay.userregistration.stream.TheatreStream;
import com.stackroute.eplay.userregistration.stream.UserRegistrationStream;

@EnableBinding({ TheatreStream.class, RSVPEventStream.class })
public class KafkaListener {

	private UserService userService;
	private UserRegistrationStream userRegistrationStream;

	@Autowired
	public KafkaListener(UserService userService, UserRegistrationStream userRegistrationStream) {
		this.userService = userService;
		this.userRegistrationStream = userRegistrationStream;
	}

	@StreamListener(TheatreStream.INPUT)
	public void movieEventPost(@Payload Theatre theatre) {
		String userName = theatre.getUserName();
		try {
			User user = userService.getUserByUsername(userName).get();
			System.out.println(user.getUserName()+ " "+user.getFullName());
			List<Theatre> theatres;
			if(user.getTheatres()==null)
				theatres = new ArrayList<>();
			else
				theatres =user.getTheatres();
			theatres.add(theatre);
			user.setTheatres(theatres);
			
			/* 
			 * updating the content in database
			 */
			
			userService.updateUser(user, userName);
			
			/*
			 * putting content in the message bus
			 */
			
			MessageChannel messageChannel = userRegistrationStream.outboundUserRegistration();
			messageChannel.send(MessageBuilder.withPayload(user)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}

	@StreamListener(RSVPEventStream.INPUT)
	public void ticketedEventPost(@Payload RSVPEvent rsvpEvent) {
		System.out.println(rsvpEvent.toString() + " ticketedmovie");
		
		
		String userName = rsvpEvent.getUserName();
		try {
			User user = userService.getUserByUsername(userName).get();
			System.out.println(user.getUserName()+ " "+user.getFullName());
			List<RSVPEvent> rsvpEvents;
			if(user.getRsvpEvents()==null)
				rsvpEvents = new ArrayList<>();
			else
				rsvpEvents =user.getRsvpEvents();
			rsvpEvents.add(rsvpEvent);
			user.setRsvpEvents(rsvpEvents);
			
			/* 
			 * updating the content in database
			 */
			
			userService.updateUser(user, userName);
			
			/*
			 * putting content in the message bus
			 */
			
			MessageChannel messageChannel = userRegistrationStream.outboundUserRegistration();
			messageChannel.send(MessageBuilder.withPayload(user)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}

	}
}
