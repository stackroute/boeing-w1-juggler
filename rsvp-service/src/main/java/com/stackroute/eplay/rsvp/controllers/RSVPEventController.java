package com.stackroute.eplay.rsvp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.rsvp.domain.RSVPEvent;
import com.stackroute.eplay.rsvp.services.RsvpCreateServiceImpl;
import com.stackroute.eplay.rsvp.streams.RSVPEventStreams;

import lombok.NoArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
@EnableBinding(RSVPEventStreams.class)
@NoArgsConstructor
public class RSVPEventController {

	private RsvpCreateServiceImpl rsvpCreateServiceImpl;
	private RSVPEventStreams rsvpEventStreams;

	@Autowired
	public RSVPEventController(RsvpCreateServiceImpl rsvpCreateServiceImpl) {
		super();
		this.rsvpCreateServiceImpl = rsvpCreateServiceImpl;
	}

	@PostMapping("/rsvpEvent")
	public ResponseEntity<?> saveRsvpEvent(@RequestBody RSVPEvent rsvpCreate) {
		return new ResponseEntity<RSVPEvent>(rsvpCreateServiceImpl.saveRsvpCreate(rsvpCreate), HttpStatus.CREATED);
	}

	@GetMapping("/rsvpEvents")
	public ResponseEntity<?> getAllRsvpEvents() {
		return new ResponseEntity<Iterable<RSVPEvent>>(rsvpCreateServiceImpl.getAllRsvpCreate(), HttpStatus.OK);
	}

	@GetMapping("/rsvpEvent/{id}")
	public ResponseEntity<?> getRsvpById(@PathVariable int id) {
		return new ResponseEntity<RSVPEvent>(rsvpCreateServiceImpl.getRsvpCreateById(id).get(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/rsvpEvent/{id}")
	public ResponseEntity<?> deleteRsvp(@PathVariable int id) {
		rsvpCreateServiceImpl.deleteRsvpCreate(id);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@PutMapping("/rsvpEvent/{id}")
	public ResponseEntity<?> updateRsvp(@PathVariable int id, @RequestBody RSVPEvent rsvpCreate) {
		MessageChannel messageChannel = rsvpEventStreams.outboundRSVPEvent();
		messageChannel.send(MessageBuilder.withPayload(rsvpCreate)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		return new ResponseEntity<RSVPEvent>(rsvpCreateServiceImpl.updateRsvp(rsvpCreate, id), HttpStatus.OK);
	}
}
