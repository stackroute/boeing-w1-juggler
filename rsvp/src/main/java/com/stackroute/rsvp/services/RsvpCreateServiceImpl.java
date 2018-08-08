package com.stackroute.rsvp.services;

import java.util.List;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.rsvp.domain.RsvpCreate;
import com.stackroute.rsvp.repositories.RsvpCreateRepository;

@Service
public class RsvpCreateServiceImpl implements RsvpCreateService{
	
	
	private RsvpCreateRepository rsvpCreateRepository;

	@Autowired
	public RsvpCreateServiceImpl(RsvpCreateRepository rsvpCreateRepository) {
		super();
		this.rsvpCreateRepository = rsvpCreateRepository;
	}

	@Override
	public RsvpCreate saveRsvpCreate(RsvpCreate rsvpCreate) {
		// TODO Auto-generated method stub
		return rsvpCreateRepository.save(rsvpCreate);
	}

	@Override
	public Iterable<RsvpCreate> getAllRsvpCreate() {
		// TODO Auto-generated method stub
		return rsvpCreateRepository.findAll();
	}

	@Override
	public Optional<RsvpCreate> getRsvpCreateById(String id) {
		// TODO Auto-generated method stub
		if(rsvpCreateRepository.existsById(id))
		{
			return rsvpCreateRepository.findById(id);
		}
		return null;
	}

	@Override
	public boolean deleteRsvpCreate(String id) {
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
	public RsvpCreate updateRsvp(RsvpCreate rsvpCreate, String id) {
		// TODO Auto-generated method stub
		rsvpCreate.setId(id);
		return rsvpCreateRepository.save(rsvpCreate);
	}

}
