package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ShowStreams {
	
	String OUTPUT = "show-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();
}
