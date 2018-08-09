package com.stackroute.searchservice.servicestest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.searchservice.domain.Event;
import com.stackroute.searchservice.repositories.QuerySearchServiceRepository;
import com.stackroute.searchservice.services.SearchServiceImpl;

public class ServiceTests {

	
	@Mock
	private transient QuerySearchServiceRepository searchServiceRepository;
	private transient Event event;
	
	@InjectMocks
	private transient SearchServiceImpl searchServiceImpl;
	
	/**
     * variable to hold user defined movies list
     */
	private transient Optional<Event> options;
	
	  /**
     * Initializing the declarations
     */
	@Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        event = new Event("name","poster");
        options = Optional.of(event);

    }
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	
	
            
            
    }


