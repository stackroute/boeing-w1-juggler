package com.stackroute.eplay.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MovieStreams {

    String OUTPUT = "movie-out";
    @Output(OUTPUT)
    MessageChannel outboundEvents();
}
