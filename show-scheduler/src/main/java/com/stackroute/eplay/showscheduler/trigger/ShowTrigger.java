package com.stackroute.eplay.showscheduler.trigger;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.showscheduler.domain.MovieEvent;
import com.stackroute.eplay.showscheduler.domain.Show;
import com.stackroute.eplay.showscheduler.job.ShowJob;

@Service
public class ShowTrigger {

	Map<Integer, Show> showMap;

	public ShowTrigger() {
		showMap = new HashMap<Integer, Show>();
	}

	public void trigger(MovieEvent movieEvent) throws SchedulerException {

		List<Show> shows = movieEvent.getShows();

		Scheduler sc = StdSchedulerFactory.getDefaultScheduler();

		for (Show show : shows) {
			System.out.println("shows: " + show);

			JobKey jobKey = JobKey.jobKey("job" + Integer.toString(show.getShowId()));
			JobDetail job = JobBuilder.newJob(ShowJob.class).withIdentity(jobKey).build();

			long currentTimeInMilliSeconds = System.currentTimeMillis();

			LocalTime showTime = show.getStartTime();
			LocalDate showDate = show.getDate();
			LocalDateTime showDateTime = LocalDateTime.of(showDate, showTime);
			long showTimeInMilliSeconds = Timestamp.valueOf(showDateTime).getTime();

			long secondsDiff = (showTimeInMilliSeconds - currentTimeInMilliSeconds) / 1000;

			System.out.println("time diff: " + (int) secondsDiff);

			TriggerKey triggerKey = TriggerKey.triggerKey("trigger" + Integer.toString(show.getShowId()));
			SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey)
					.startAt(futureDate((int) secondsDiff, IntervalUnit.SECOND)).forJob(job)
					.withSchedule(simpleSchedule()).build();

			showMap.put(show.getShowId(), show);

			sc.getContext().put("show", showMap);
			sc.scheduleJob(job, trigger);

			// showServiceImpl.updateShow(show, show.getShowId());
			// Show updatedShow = showServiceImpl.updateShow(show, show.getShowId());
			// return updatedShow;
		}
		sc.start();

	}

}
