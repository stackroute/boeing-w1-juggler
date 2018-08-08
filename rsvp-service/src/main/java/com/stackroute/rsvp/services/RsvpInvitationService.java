package com.stackroute.rsvp.services;

import java.util.Optional;

import com.stackroute.rsvp.domain.RsvpInvitation;

public interface RsvpInvitationService {
	
public RsvpInvitation saveRsvpInvitation(RsvpInvitation rsvpInvitation);
	
	public Iterable<RsvpInvitation> getAllRsvpInvitation();
	
	public Optional<RsvpInvitation> getRsvpInvitationByInvitationId(String invitationId);
	
	public boolean deleteRsvpInvitation(String invitationId);
	
	public RsvpInvitation updateRsvpInvitation (RsvpInvitation rsvpInvitation,String invitationId);
	

}
