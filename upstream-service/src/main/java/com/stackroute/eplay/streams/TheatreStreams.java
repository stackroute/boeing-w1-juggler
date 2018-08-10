package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//Stream defined for writing messages to Message Bus
public interface TheatreStreams {
	
	String OUTPUT = "theatre-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();
}
