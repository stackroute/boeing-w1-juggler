package com.stackroute.searchservice.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.searchservice.domain.Event;
import com.stackroute.searchservice.domain.Query;

public interface SearchService {

	public Iterable<Event> getEventsByCity(String city) ;

	Iterable<Query> getAllQueries();
	
	
	
}
