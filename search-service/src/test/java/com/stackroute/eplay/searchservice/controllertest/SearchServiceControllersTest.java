package com.stackroute.eplay.searchservice.controllertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.stackroute.eplay.search.Search;
import com.stackroute.eplay.search.controller.SearchServiceControllers;
import com.stackroute.eplay.search.services.SearchServiceImpl;
import com.stackroute.eplay.search.domain.City;
import com.stackroute.eplay.search.domain.Movie;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Search.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(SearchServiceControllers.class)
public class SearchServiceControllersTest {
    
	@LocalServerPort
	private int port;
	
	Movie movie1, movie2, movie3;
	City city1, city2;
	
	private TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	HttpEntity<City> entity;
	
	private String createURLWithPort(String uri) {
		return "http://localhost:"+port+uri;
	}
	
	@Before
	public void setUp() throws Exception {
		movie1 = new Movie(1, "1", "1", null, null, null, null, null, 0, 0, null);
		movie2 = new Movie(2, "2", "2", null, null, null, null, null, 0, 0, null);
		movie3 = new Movie(3, "3", "3", null, null, null, null, null, 0, 0, null);
				
		List<Movie> movieList1 = new ArrayList<Movie>();
		movieList1.add(movie1);
		
		List<Movie> movieList2 = new ArrayList<Movie>();
		movieList2.add(movie2); movieList2.add(movie3);
		
		city1 = new City("mumbai",  movieList1);
		city2 = new City("delhi", movieList2);
		entity = new HttpEntity<City>(city1, headers);
		
	}
	
	@After
	public void tearDown() throws Exception {
		restTemplate.exchange(createURLWithPort("api/vi/mumbai"), HttpMethod.DELETE, entity, String.class);
	}
	
	@Test
	public void testGetEventsByCity() throws Exception {
		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/api/v1/mumbai"), HttpMethod.GET,
				entity, String.class);
		System.out.println(response);
		assertNotNull(response);
		String actual = response.getBody();
		assertNotNull(actual);
		assertEquals(200, response.getStatusCodeValue());
	}

}