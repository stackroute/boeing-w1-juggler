package com.stackroute.eplay.showscheduler.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ShowSchedulerStream {


	String INPUT = "show-scheduler-in";
	@Input(INPUT)
	SubscribableChannel inboundShowScheduler();
	String OUTPUT = "show-scheduler-out";
	@Output(OUTPUT)
	MessageChannel outboundShowScheduler();
}