package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MovieEventStreams {

    String OUTPUT = "movie-event-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();
}
