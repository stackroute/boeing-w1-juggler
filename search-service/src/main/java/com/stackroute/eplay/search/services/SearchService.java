package com.stackroute.eplay.search.services;

import java.util.List;
import java.util.Optional;

import com.stackroute.eplay.search.domain.City;
import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.Query;
import com.stackroute.eplay.search.domain.TicketedEvent;

public interface SearchService {

	public Movie saveMovie(Movie movie);
	public Iterable<Movie> getEventsByCity(String city) ;

	Iterable<Query> getAllQueries();
	City updateCityMovies(String cityName, Movie movie);
	Movie getMovieById(int id);
	
	
	
}
