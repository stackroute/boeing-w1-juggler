package com.stackroute.eplay.ticketengine.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PaymentStatusStream {
	String INPUT = "payment-status-in";
    @Input(INPUT)
    SubscribableChannel inboundMovieEvent();
}
