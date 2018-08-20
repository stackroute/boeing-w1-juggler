package com.stackroute.eplay.showscheduler.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ShowSchedulerStream {

	String OUTPUT = "show-scheduler-out";
	String INPUT = "show-scheduler-in";

	@Input(INPUT)
	SubscribableChannel inboundShowScheduler();

	@Output(OUTPUT)
	MessageChannel outboundShowScheduler();
}