package com.stackroute.eplay.recommendationservice.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.recommendationservice.domain.City;
import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.User;
import com.stackroute.eplay.recommendationservice.services.CityService;
import com.stackroute.eplay.recommendationservice.services.MovieService;
import com.stackroute.eplay.recommendationservice.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RecommendationServiceController {
	private MovieService movieservice;
	private UserService userservice;
	private CityService cityservice;
	
	@Autowired
	public RecommendationServiceController(MovieService movieservice, UserService userservice,CityService cityservice) {
		this.movieservice = movieservice;
		this.userservice = userservice;
		this.cityservice = cityservice;
	}
	
	@PostMapping("/saveMovie")
	public ResponseEntity<?> createMovieNode(@RequestBody Movie movie) {
	    movie.setCities(movie.getCities());
		return new ResponseEntity<Movie> (movieservice.saveMovie(movie),HttpStatus.OK);
		
	}
	
	@PostMapping("/saveUser")	
	public ResponseEntity<?> createUserNode(@RequestBody User user){
		user.setMovies(user.getMovies());
		return new ResponseEntity<User>(userservice.saveUser(user),HttpStatus.OK);
	}
	
	@PostMapping("/saveCity")
	public ResponseEntity<?> createCityNode(@RequestBody City city){
		city.setMovies(city.getMovies());
		return new ResponseEntity<City>(cityservice.saveCity(city),HttpStatus.OK);
	}
	
	@GetMapping("/getMovieByTitle")
    public ResponseEntity <?> getMovieByTitle(@RequestParam String title) {
			return new ResponseEntity<Movie> (movieservice.findByTitle(title),HttpStatus.OK);	
	}
	
//	@PostMapping("/getAllFollowers/{name}")
//	public ResponseEntity<?> getAllFollowers(@PathVariable String name){
//		return new ResponseEntity<User>(userservice.getAllFollowers(name),HttpStatus.OK);
//	}
	
}
