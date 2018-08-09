package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface RSVPEventStreams {

    String OUTPUT = "RSVP-event-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();	// to write messages to kafka
}
