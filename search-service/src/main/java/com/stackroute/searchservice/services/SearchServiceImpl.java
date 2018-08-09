package com.stackroute.searchservice.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.searchservice.domain.Event;
import com.stackroute.searchservice.domain.Query;
import com.stackroute.searchservice.repositories.EventSearchServiceRepository;
import com.stackroute.searchservice.repositories.QuerySearchServiceRepository;

@Service
public class SearchServiceImpl implements SearchService{

	private QuerySearchServiceRepository searchServiceRepository;
	private EventSearchServiceRepository eventSearchServiceRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public SearchServiceImpl(QuerySearchServiceRepository searchServiceRepository,EventSearchServiceRepository eventSearchServiceRepository) {
		super();
		this.searchServiceRepository = searchServiceRepository;
		this.eventSearchServiceRepository=eventSearchServiceRepository;
	}

	@Override
	public Iterable<Event> getEventsByCity(String city) {
		// TODO Auto-generated method stub
		Query query=new Query();
		LocalDateTime now = LocalDateTime.now();
		query.setQuery("city="+city);
		query.setUserId("guest");
		query.setTimeStamp(now);
		searchServiceRepository.save(query);
		return eventSearchServiceRepository.getEventsByCity(city);
	}	
	@Override
	public Iterable<Query> getAllQueries() {
		// TODO Auto-generated method stub
		return searchServiceRepository.findAll();
	}	
//	@KafkaListener(topics = "Skills", group = "group_json",
//            containerFactory = "userKafkaListenerFactory")
//    public void consumeJson(Event event) {
//        System.out.println(event);
//    }
}
