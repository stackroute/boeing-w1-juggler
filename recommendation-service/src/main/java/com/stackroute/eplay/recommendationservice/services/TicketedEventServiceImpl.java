package com.stackroute.eplay.recommendationservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.recommendationservice.domain.TicketedEvent;
import com.stackroute.eplay.recommendationservice.repositories.TicketedEventRepository;
@Service
public class TicketedEventServiceImpl implements TicketedEventService {
	private TicketedEventRepository ticketedEventRepository;
	
	@Autowired
	public TicketedEventServiceImpl(TicketedEventRepository ticketedEventRepository) {
		super();
		this.ticketedEventRepository = ticketedEventRepository;
	}
		
	public TicketedEvent saveTicketedEvent(TicketedEvent ticketedevent) {
		return ticketedEventRepository.save(ticketedevent);
	}

	@Override
	public TicketedEvent findById(int id) {
		return ticketedEventRepository.findById(id);
	}

	@Override
	public TicketedEvent findByName(String name) {
		return ticketedEventRepository.findByName(name);
	}
}
