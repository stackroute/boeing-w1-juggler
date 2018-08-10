package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//Stream defined for writing messages to Message Bus
public interface ShowStreams {
	
	String OUTPUT = "show-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();
}
