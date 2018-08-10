package com.stackroute.eplay.ticketservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.stackroute.eplay.ticketservice.domain.TicketedEvent;
import com.stackroute.eplay.ticketservice.exception.TicketedEventAlreadyExistException;
import com.stackroute.eplay.ticketservice.repositories.TicketedEventRepository;
import com.stackroute.eplay.ticketservice.streams.TicketedEventStreams;

@Service
public class TicketedEventServiceImpl implements TicketedEventService {
	TicketedEventRepository ticketedEventRepository;
	TicketedEventStreams ticketedEventStreams;

	@Autowired
	public TicketedEventServiceImpl(TicketedEventRepository ticketedEventRepository,
			TicketedEventStreams ticketedEventStreams) {
		this.ticketedEventRepository = ticketedEventRepository;
		this.ticketedEventStreams = ticketedEventStreams;
	}

	@Override
	public TicketedEvent saveTicketedEvent(TicketedEvent ticketedEvent) throws TicketedEventAlreadyExistException {
		TicketedEvent te = getTicketedEventById(ticketedEvent.getId());
		if (te == null) {
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
}
