package com.stackroute.eplay.ticketengine.service;

import java.util.HashMap;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;


public class SeatsJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		SchedulerContext schedulerContext;

		try {

			/*
			 * Getting all the shows from the trigger class in the form of Hashmap and
			 * changing the status of the each show as soon as their time is triggered.
			 */
            
			schedulerContext = context.getScheduler().getContext();
			String id=schedulerContext.getString("seat");
			System.out.println(id);
            
			

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		
	}

}
