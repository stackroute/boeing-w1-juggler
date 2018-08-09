package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface TicketedEventStreams {

	String OUTPUT = "ticketed-event-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();
}
