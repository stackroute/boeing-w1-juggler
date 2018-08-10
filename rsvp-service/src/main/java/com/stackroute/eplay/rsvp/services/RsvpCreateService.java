package com.stackroute.eplay.rsvp.services;

import java.util.Optional;

import com.stackroute.eplay.rsvp.domain.RSVPEvent;

public interface RsvpCreateService {

	
	public RSVPEvent saveRsvpCreate(RSVPEvent rsvpCreate);
	
	public Iterable<RSVPEvent> getAllRsvpCreate();
	
	public Optional<RSVPEvent> getRsvpCreateById(int id);
	
	public boolean deleteRsvpCreate(int id);
	
	public RSVPEvent updateRsvp (RSVPEvent rsvpCreate,int id);
	
	
}
