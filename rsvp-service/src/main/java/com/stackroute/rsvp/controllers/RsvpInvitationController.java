package com.stackroute.rsvp.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.stackroute.rsvp.domain.RsvpInvitation;
import com.stackroute.rsvp.services.RsvpInvitationServiceImpl;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RsvpInvitationController {

	
	private RsvpInvitationServiceImpl rsvpInvitationServiceImpl;
	private Environment env;
	
	@Autowired
	public RsvpInvitationController(RsvpInvitationServiceImpl rsvpInvitationServiceImpl, Environment env) {
		super();
		this.rsvpInvitationServiceImpl = rsvpInvitationServiceImpl;
		this.env = env;
	}
	
	@PostMapping("/rsvpEvent")
	public ResponseEntity<?> saveRsvpEvent(@RequestBody RsvpInvitation rsvpInvitation)
	{
		return new ResponseEntity<RsvpInvitation>(rsvpInvitationServiceImpl.saveRsvpInvitation(rsvpInvitation),HttpStatus.CREATED);
	}
	
	@GetMapping("/rsvpEvents")
	public ResponseEntity<?> getAllRsvpEvents()
	{
		return new ResponseEntity<Iterable<RsvpInvitation>>(rsvpInvitationServiceImpl.getAllRsvpInvitation(),HttpStatus.OK);
	}
	
	@GetMapping("/rsvpEvent/{invitationId}")
	public ResponseEntity<?> getRsvpById(@PathVariable String invitationId)
	{
		return new ResponseEntity<Optional<RsvpInvitation>>(rsvpInvitationServiceImpl.getRsvpInvitationByInvitationId(invitationId),HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/rsvpEvent/{invitationId}", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> deleteRsvp(@PathVariable String invitationId)
	{
		rsvpInvitationServiceImpl.deleteRsvpInvitation(invitationId);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/rsvpEvent{invitationId}")
	public ResponseEntity<?> updateRsvp(@PathVariable String invitationId,@RequestBody RsvpInvitation rsvpInvitation)
	{
		return new ResponseEntity<RsvpInvitation>(rsvpInvitationServiceImpl.updateRsvpInvitation(rsvpInvitation, invitationId),HttpStatus.OK);
	}
}
