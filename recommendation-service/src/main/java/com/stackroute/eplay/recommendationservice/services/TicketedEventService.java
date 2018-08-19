package com.stackroute.eplay.recommendationservice.services;
import com.stackroute.eplay.recommendationservice.domain.TicketedEvent;

public interface TicketedEventService {
	public TicketedEvent saveTicketedEvent(TicketedEvent ticketedevent);
	public TicketedEvent findById(int id);
	public TicketedEvent findByName(String name);
}
