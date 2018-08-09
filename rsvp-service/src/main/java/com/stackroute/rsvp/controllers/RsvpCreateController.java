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

import com.stackroute.rsvp.domain.RsvpCreate;
import com.stackroute.rsvp.services.RsvpCreateServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RsvpCreateController {

	private RsvpCreateServiceImpl rsvpCreateServiceImpl;
	private Environment env;
	
	@Autowired
	public RsvpCreateController(RsvpCreateServiceImpl rsvpCreateServiceImpl, Environment env) {
		super();
		this.rsvpCreateServiceImpl = rsvpCreateServiceImpl;
		this.env = env;
	}
	
	@PostMapping("/rsvpEvent")
	public ResponseEntity<?> saveRsvpEvent(@RequestBody RsvpCreate rsvpCreate)
	{
		return new ResponseEntity<RsvpCreate>(rsvpCreateServiceImpl.saveRsvpCreate(rsvpCreate),HttpStatus.CREATED);
	}
	
	@GetMapping("/rsvpEvents")
	public ResponseEntity<?> getAllRsvpEvents()
	{
		return new ResponseEntity<Iterable<RsvpCreate>>(rsvpCreateServiceImpl.getAllRsvpCreate(),HttpStatus.OK);
	}
	
	@GetMapping("/rsvpEvent/{id}")
	public ResponseEntity<?> getRsvpById(@PathVariable String id)
	{
		return new ResponseEntity<Optional<RsvpCreate>>(rsvpCreateServiceImpl.getRsvpCreateById(id),HttpStatus.OK);
	}
	
	
	@DeleteMapping(path="/rsvpEvent/{id}", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<?> deleteRsvp(@PathVariable String id)
	{
		rsvpCreateServiceImpl.deleteRsvpCreate(id);
		return new ResponseEntity<String>("Deleted",HttpStatus.OK);
	}
	
	@PutMapping("/rsvpEvent{id}")
	public ResponseEntity<?> updateRsvp(@PathVariable String id,@RequestBody RsvpCreate rsvpCreate)
	{
		return new ResponseEntity<RsvpCreate>(rsvpCreateServiceImpl.updateRsvp(rsvpCreate, id),HttpStatus.OK);
	}
}
