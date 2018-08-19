package com.stackroute.eplay.recommendationservice.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.eplay.recommendationservice.domain.Category;
import com.stackroute.eplay.recommendationservice.domain.City;
import com.stackroute.eplay.recommendationservice.domain.Genre;
import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.MovieEvent;
import com.stackroute.eplay.recommendationservice.domain.MovieKafka;
import com.stackroute.eplay.recommendationservice.domain.TicketedEvent;
import com.stackroute.eplay.recommendationservice.domain.TicketedEventKafka;
import com.stackroute.eplay.recommendationservice.domain.User;
import com.stackroute.eplay.recommendationservice.services.CityService;
import com.stackroute.eplay.recommendationservice.services.MovieService;
import com.stackroute.eplay.recommendationservice.services.TicketedEventService;
import com.stackroute.eplay.recommendationservice.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RecommendationServiceController {
	private MovieService movieservice;
	private UserService userservice;
	private CityService cityservice;
	private TicketedEventService ticketedEventService;
	
	@Autowired
	public RecommendationServiceController(MovieService movieservice, UserService userservice,CityService cityservice,TicketedEventService ticketedEventService) {
		this.movieservice = movieservice;
		this.userservice = userservice;
		this.cityservice = cityservice;
		this.ticketedEventService = ticketedEventService;
	}
	
	//taking moviekafka and mapping to movie
	//We will get data from kafka in movieKafka format 
	@PostMapping("/saveMovie")
	public ResponseEntity<?> createMovieNode(@RequestBody MovieKafka movieKafka) {
		int id = movieKafka.getId();
		String name = movieKafka.getName();
		String language = movieKafka.getLanguage();
		int ratings = movieKafka.getRating();
		String g = movieKafka.getGenre();
		Date releaseDate = movieKafka.getReleaseDate();
		Genre genre = new Genre(g);
		Movie movie = new Movie(id,name,language,ratings,genre,releaseDate);
		return new ResponseEntity<Movie> (movieservice.saveMovie(movie),HttpStatus.OK);		
	}
	
	@PostMapping("/saveTicketedEvent")
	public ResponseEntity<?> createTicketedEventNode(@RequestBody TicketedEventKafka ticketedEventKafka) {
		int id = ticketedEventKafka.getId();
		String name = ticketedEventKafka.getName();
		Date date = ticketedEventKafka.getDate();
		City city = new City(ticketedEventKafka.getCity());
		Category category =  new Category(ticketedEventKafka.getType());
		TicketedEvent ticketedEvent = new TicketedEvent(id,name,date,city,category);
		return new ResponseEntity<TicketedEvent> (ticketedEventService.saveTicketedEvent(ticketedEvent),HttpStatus.OK);		
	}
	@PostMapping("/saveUser")	
	public ResponseEntity<?> createUserNode(@RequestBody User user){
		user.setMovies(user.getMovies());
		return new ResponseEntity<User>(userservice.saveUser(user),HttpStatus.OK);
	}
	
	@PostMapping("/ReleasedIn")
	public ResponseEntity<?> createCityNode(@RequestBody MovieEvent movieEvent){
		int movieId = movieEvent.getMovieId();
		String cityName = movieEvent.getCity();
		City city = cityservice.findBycityName(cityName);
		if(city == null) {
			cityservice.saveCity(new City(cityName));
		}
		Movie movie = movieservice.findById(movieId);
		movieservice.releasedIn(cityName, movieId);
		return new ResponseEntity<Movie> (movie,HttpStatus.OK);
		/*City city = cityservice.saveCity(new City(cityName));
		movie.getCities().add(city);*/
		//return new ResponseEntity<Movie> (movieservice.saveMovie(movie),HttpStatus.OK);
		//movieservice.saveMovie(movie);
//		city.setMovies(city.getMovies());
//		return new ResponseEntity<City>(cityservice.saveCity(city),HttpStatus.OK);
	}
	
	@GetMapping("/getMovieByName")
    public ResponseEntity <?> getMovieByName(@RequestParam String name) {
			return new ResponseEntity<Movie> (movieservice.findByName(name),HttpStatus.OK);	
	}
	
	@GetMapping("/getMovieById")
	public ResponseEntity<?> getMovieById(@RequestParam int id){
		return new ResponseEntity<Movie> (movieservice.findById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getCityByName")
	public ResponseEntity<?> getCityById(@RequestParam String name){
		return new ResponseEntity<City> (cityservice.findBycityName(name),HttpStatus.OK);
	}
	
	@GetMapping("/getMoviesByGenre")
	public ResponseEntity<?> getMoviesByGenre(@RequestParam String genreName){
		return new ResponseEntity<List<Movie>> (movieservice.getMoviesByGenre(genreName),HttpStatus.OK);
	}
	
	
	@GetMapping("/getMoviesByCity")
	public ResponseEntity<?> getMoviesByCity(@RequestParam String name){
		return new ResponseEntity<List<Movie>> (movieservice.getMoviesByCity(name),HttpStatus.OK);
	}
	
	//http://localhost:8080/api/v1/getMovieByCityGenre?name=Bangalore&genreName=comedy
	@GetMapping("/getMovieByCityGenre")
	public ResponseEntity<?> getMovieByCityGenre(@RequestParam String name,@RequestParam String genreName){
		return new ResponseEntity<List<Movie>> (movieservice.getMovieByCityGenre(name,genreName),HttpStatus.OK);
	}
//	@PostMapping("/getAllFollowers/{name}")
//	public ResponseEntity<?> getAllFollowers(@PathVariable String name){
//		return new ResponseEntity<User>(userservice.getAllFollowers(name),HttpStatus.OK);
//	}
	
}
