package com.stackroute.eplay.downstreamservice.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RSVPEventStreams {
	String INPUT = "RSVP-event-in";
    @Input(INPUT)
    SubscribableChannel inboundRSVPEvent();
}
