package com.stackroute.rsvp.services;

import java.util.Optional;


import com.stackroute.rsvp.domain.RsvpCreate;

public interface RsvpCreateService {

	
	public RsvpCreate saveRsvpCreate(RsvpCreate rsvpCreate);
	
	public Iterable<RsvpCreate> getAllRsvpCreate();
	
	public Optional<RsvpCreate> getRsvpCreateById(String id);
	
	public boolean deleteRsvpCreate(String id);
	
	public RsvpCreate updateRsvp (RsvpCreate rsvpCreate,String id);
	
	
}
