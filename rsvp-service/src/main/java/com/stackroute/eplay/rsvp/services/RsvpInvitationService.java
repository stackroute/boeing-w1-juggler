package com.stackroute.eplay.rsvp.services;

import java.util.Optional;

import com.stackroute.eplay.rsvp.domain.Invitation;

public interface RsvpInvitationService {
	
public Invitation saveRsvpInvitation(Invitation rsvpInvitation);
	
	public Iterable<Invitation> getAllRsvpInvitation();
	
	public Optional<Invitation> getRsvpInvitationByInvitationId(int invitationId);
	
	public boolean deleteRsvpInvitation(int invitationId);
	
	public Invitation updateRsvpInvitation (Invitation rsvpInvitation,int invitationId);
	

}
