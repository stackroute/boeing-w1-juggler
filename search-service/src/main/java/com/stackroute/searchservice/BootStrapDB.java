package com.stackroute.searchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.boot.CommandLineRunner;

import com.stackroute.searchservice.domain.Event;
import com.stackroute.searchservice.repositories.EventSearchServiceRepository;

@Configuration
public class BootStrapDB implements ApplicationListener<ContextRefreshedEvent> {
	//public class BootStrapDB implements CommandLineRunner{
	
	
private EventSearchServiceRepository eventSearchServiceRepository;
    
    @Autowired
    public BootStrapDB(EventSearchServiceRepository eventSearchServiceRepository) {
        this.eventSearchServiceRepository=eventSearchServiceRepository;
    }
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Event eve=new Event("something","poster","bangalore");
		eventSearchServiceRepository.save(eve);
		Event eve1=new Event("something","poster","bangalore");
		eventSearchServiceRepository.save(eve1);
		Event eve2=new Event("something","poster","mumbai");
		eventSearchServiceRepository.save(eve2);
		Event eve3=new Event("something","poster","delhi");
		eventSearchServiceRepository.save(eve3);
		
	}
//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		
//		
//	}

}
