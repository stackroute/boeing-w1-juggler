package com.stackroute.eplay.search.services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.search.domain.City;
import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.Query;
import com.stackroute.eplay.search.domain.TicketedEvent;
import com.stackroute.eplay.search.repositories.CityRepository;
import com.stackroute.eplay.search.repositories.MovieRepository;
import com.stackroute.eplay.search.repositories.QueryRepository;

@Service
public class SearchServiceImpl implements SearchService{

	private QueryRepository queryRepository;
	private CityRepository cityRepository;
	private MovieRepository movieRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public SearchServiceImpl(QueryRepository queryRepository,CityRepository cityRepository, MovieRepository movieRepository) {
		super();
		this.queryRepository = queryRepository;
		this.cityRepository = cityRepository;
		this.movieRepository = movieRepository;
	}
	
	@Override
	public Movie saveMovie(Movie movie) {
		if (!movieRepository.existsById(movie.getId())) {
			return movieRepository.save(movie);
		} 
		return null;
	}
	
	@Override
	public City updateCityMovies(String cityName, Movie movie) {
		City city;
		
		if(!cityRepository.existsById(cityName)) {
			List<Movie> movieList = new ArrayList<Movie>();
			movieList.add(movie);
			
			city = new City(cityName, movieList);
			return cityRepository.save(city);
		}
		
		city = cityRepository.findById(cityName).get();
		if(!city.getMovieList().contains(movie)) {
			city.getMovieList().add(movie);
			return cityRepository.save(city);
		}
		
		return null;

	}
	
	@Override
	public Movie getMovieById(int id) {
		return movieRepository.findById(id);
	}

	@Override
	public Iterable<Movie> getEventsByCity(String city) {
		// TODO Auto-generated method stub
		Query query=new Query();
		LocalDateTime now = LocalDateTime.now();
		query.setQuery("city="+city);
		query.setUserId("guest");
		query.setTimeStamp(now);
		queryRepository.save(query);
		
		//System.out.println(cityRepository.findById(city).get());
		return cityRepository.findById(city).get().getMovieList();
	}	
	
	@Override
	public Iterable<Query> getAllQueries() {
		// TODO Auto-generated method stub
		return queryRepository.findAll();
	}	
}
