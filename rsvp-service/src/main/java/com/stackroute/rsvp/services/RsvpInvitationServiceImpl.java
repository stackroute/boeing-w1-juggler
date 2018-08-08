package com.stackroute.rsvp.services;


import java.util.List;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.rsvp.domain.RsvpInvitation;
import com.stackroute.rsvp.repositories.RsvpInvitationRepository;

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
	public RsvpInvitation saveRsvpInvitation(RsvpInvitation rsvpInvitation) {
		// TODO Auto-generated method stub
		return rsvpInvitationRepository.save(rsvpInvitation);
	}

	@Override
	public Iterable<RsvpInvitation> getAllRsvpInvitation() {
		// TODO Auto-generated method stub
		return rsvpInvitationRepository.findAll();
	}

	@Override
	public Optional<RsvpInvitation> getRsvpInvitationByInvitationId(String invitationId) {
		// TODO Auto-generated method stub
		return rsvpInvitationRepository.findById(invitationId);
	}

	@Override
	public boolean deleteRsvpInvitation(String invitationId) {
		// TODO Auto-generated method stub
		if(rsvpInvitationRepository.existsById(invitationId))
		{
			rsvpInvitationRepository.deleteById(invitationId);
			return true;
		}
		return false;
	}

	@Override
	public RsvpInvitation updateRsvpInvitation(RsvpInvitation rsvpInvitation, String invitationId) {
		// TODO Auto-generated method stub
		rsvpInvitation.setinvitationId(invitationId);
		return rsvpInvitationRepository.save(rsvpInvitation);
	}

	
	
}
