package com.stackroute.eplay.rsvp.services;


import java.util.List;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.rsvp.domain.Invitation;
import com.stackroute.eplay.rsvp.repositories.RsvpInvitationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RsvpInvitationServiceImpl implements RsvpInvitationService{

	
	private RsvpInvitationRepository rsvpInvitationRepository;
	@Autowired
	public RsvpInvitationServiceImpl(RsvpInvitationRepository rsvpInvitationRepository) {
		super();
		this.rsvpInvitationRepository = rsvpInvitationRepository;
	}

	@Override
	public Invitation saveRsvpInvitation(Invitation rsvpInvitation) {
		// TODO Auto-generated method stub
		return rsvpInvitationRepository.save(rsvpInvitation);
	}

	@Override
	public Iterable<Invitation> getAllRsvpInvitation() {
		// TODO Auto-generated method stub
		return rsvpInvitationRepository.findAll();
	}

	@Override
	public Optional<Invitation> getRsvpInvitationByInvitationId(int invitationId) {
		// TODO Auto-generated method stub
		return rsvpInvitationRepository.findById(invitationId);
	}

	@Override
	public boolean deleteRsvpInvitation(int invitationId) {
		// TODO Auto-generated method stub
		if(rsvpInvitationRepository.existsById(invitationId))
		{
			rsvpInvitationRepository.deleteById(invitationId);
			return true;
		}
		return false;
	}

	@Override
	public Invitation updateRsvpInvitation(Invitation rsvpInvitation, int invitationId) {
		// TODO Auto-generated method stub
		rsvpInvitation.setInvitationId(invitationId);
		return rsvpInvitationRepository.save(rsvpInvitation);
	}

	
	
}
