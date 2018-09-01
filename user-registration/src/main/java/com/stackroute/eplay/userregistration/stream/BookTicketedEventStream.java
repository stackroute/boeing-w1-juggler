package com.stackroute.eplay.userregistration.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BookTicketedEventStream {
	String INPUT = "ticketed-event-ticket-in";

	@Output(INPUT)
	MessageChannel inboundTicketedEventTicket();
}
