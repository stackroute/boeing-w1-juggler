package com.stackroute.eplay.rsvp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.rsvp.domain.RSVPEvent;
import com.stackroute.eplay.rsvp.repositories.RsvpCreateRepository;

@Service
public class RsvpCreateServiceImpl implements RsvpCreateService{
	
	
	private RsvpCreateRepository rsvpCreateRepository;

	@Autowired
	public RsvpCreateServiceImpl(RsvpCreateRepository rsvpCreateRepository) {
		super();
		this.rsvpCreateRepository = rsvpCreateRepository;
	}

	@Override
	public RSVPEvent saveRsvpCreate(RSVPEvent rsvpCreate) {
		// TODO Auto-generated method stub
		return rsvpCreateRepository.save(rsvpCreate);
	}

	@Override
	public Iterable<RSVPEvent> getAllRsvpCreate() {
		// TODO Auto-generated method stub
		return rsvpCreateRepository.findAll();
	}

	@Override
	public Optional<RSVPEvent> getRsvpCreateById(int id) {
		// TODO Auto-generated method stub
		if(rsvpCreateRepository.existsById(id))
		{
			return rsvpCreateRepository.findById(id);
		}
		return null;
	}

	@Override
	public boolean deleteRsvpCreate(int id) {
		// TODO Auto-generated method stub
		if(rsvpCreateRepository.existsById(id))
		{
			rsvpCreateRepository.deleteById(id);
			return true;
		}
		else
		return false;
	}

	@Override
	public RSVPEvent updateRsvp(RSVPEvent rsvpCreate, int id) {
		// TODO Auto-generated method stub
		rsvpCreate.setId(id);
		return rsvpCreateRepository.save(rsvpCreate);
	}

}
