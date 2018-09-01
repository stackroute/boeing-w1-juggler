package com.stackroute.eplay.ticketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.ticketservice.domain.Ticket;
import com.stackroute.eplay.ticketservice.domain.TicketedEvent;
import com.stackroute.eplay.ticketservice.exception.TicketedEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.repositories.TicketedEventRepository;
import com.stackroute.eplay.ticketservice.streams.BookTicketedEventStreams;
import com.stackroute.eplay.ticketservice.streams.TicketedEventStreams;

@Service
public class TicketedEventServiceImpl implements TicketedEventService {
	TicketedEventRepository ticketedEventRepository;
	TicketedEventStreams ticketedEventStreams;
	BookTicketedEventStreams bookTicketedEventStreams;

	@Autowired
	public TicketedEventServiceImpl(TicketedEventRepository ticketedEventRepository,
			TicketedEventStreams ticketedEventStreams, 
			BookTicketedEventStreams bookTicketedEventStreams) {
		this.ticketedEventRepository = ticketedEventRepository;
		this.ticketedEventStreams = ticketedEventStreams;
		this.bookTicketedEventStreams = bookTicketedEventStreams;
	}

	@Override
	public TicketedEvent saveTicketedEvent(TicketedEvent ticketedEvent) throws TicketedEventAlreadyExistException {
		TicketedEvent te = getTicketedEventById(ticketedEvent.getId());
		if (te == null) {
			ticketedEvent.setRemainingSeats(ticketedEvent.getCapacity());
			te = ticketedEventRepository.save(ticketedEvent);
			return te;
		}
		throw new TicketedEventAlreadyExistException("This event already exists");
	}

	@Override
	public List<TicketedEvent> getAllTicketedEvent() {
		return ticketedEventRepository.findAll();
	}

	@Override
	public TicketedEvent getTicketedEventById(int ticketedEventId) {
		TicketedEvent ticketedEvent = ticketedEventRepository.getTicketedEventById(ticketedEventId);
		return ticketedEvent;
	}

	@Override
	public TicketedEvent updateTicketedEvent(TicketedEvent ticketedEvent) {
		TicketedEvent te = ticketedEventRepository.save(ticketedEvent);
		MessageChannel messageChannel = ticketedEventStreams.outboundTicketedEvent();
		messageChannel.send(MessageBuilder.withPayload(te)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
		return te;
	}

	@Override
	public Ticket bookTicketedEvent(Ticket ticket) {
		// TODO Auto-generated method stub
		int noOfSeats = ticket.getNoOfSeats();
		int ticketedEventId = ticket.getTicketedEventId();
		
		TicketedEvent ticketedEvent = getTicketedEventById(ticketedEventId);
		
		int remainingSeats = ticketedEvent.getRemainingSeats() -  noOfSeats;
		
		if(remainingSeats >= 0) {
			ticketedEvent.setRemainingSeats(remainingSeats);
			ticketedEventRepository.save(ticketedEvent);
			
			MessageChannel messageChannel = bookTicketedEventStreams.outboundTicketedEventTicket();
			messageChannel.send(MessageBuilder.withPayload(ticket)
					.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());
			
		} else {
			ticket.setNoOfSeats(-1);
		}
		
		return ticket;
	}
}
