package com.stackroute.eplay.ticketengine.service;

import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.ticketengine.domain.BlockedSeats;
import com.stackroute.eplay.ticketengine.domain.Show;
import com.stackroute.eplay.ticketengine.repository.ShowRepository;

@Service
public class SeatsJob implements Job {
	
	private static BlockedSeatsService blockedSeatsService;
	private static ShowRepository showRepository;
	
	public SeatsJob(){}
	@Autowired
	public SeatsJob(BlockedSeatsService blockedSeatsService, ShowRepository showRepository){
		if(SeatsJob.blockedSeatsService == null)
			SeatsJob.blockedSeatsService = blockedSeatsService;
		if(SeatsJob.showRepository == null)
			SeatsJob.showRepository = showRepository;
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SchedulerContext schedulerContext;
		try {
			schedulerContext = context.getScheduler().getContext();
			String id=schedulerContext.getString("seat");
			if(blockedSeatsService.findById(id)!=null) {
				BlockedSeats seats = blockedSeatsService.findById(id);
				blockedSeatsService.delete(id);
				Show show = showRepository.find(seats.getShowId());
				Map<Integer,String> showSeats = show.getSeats();
				for(int i:seats.getSeats()) {
					if(showSeats.get(i).equals("blocked")) {
						showSeats.put(i, "open");
					}
				}
				show.setSeats(showSeats);
				showRepository.update(show);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
		
	}

}
