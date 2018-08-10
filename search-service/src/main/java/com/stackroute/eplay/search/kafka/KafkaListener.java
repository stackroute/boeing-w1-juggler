package com.stackroute.eplay.search.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;

import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.MovieEvent;
import com.stackroute.eplay.search.services.SearchService;
import com.stackroute.eplay.search.streams.MovieEventStream;
import com.stackroute.eplay.search.streams.MovieStream;

@EnableBinding({MovieEventStream.class, MovieStream.class})
public class KafkaListener {
	
	private SearchService searchService;
	private MovieEventStream movieEventStream;
	private MovieStream movieStream;
	
	@Autowired
	public KafkaListener(SearchService searchService, MovieEventStream movieEventStream, MovieStream movieStream) {
		this.searchService = searchService;
		this.movieEventStream = movieEventStream;
		this.movieStream = movieStream;
	}

	@StreamListener(MovieEventStream.INPUT)
	public void movieEventPost(@Payload MovieEvent movieEvent) {
		String city = movieEvent.getCity();
		int movieId = movieEvent.getMovieId();
		Movie movie = searchService.getMovieById(movieId);
		
		searchService.updateCityMovies(city, movie);
	}
	
	@StreamListener(MovieStream.INPUT)
	public void moviePost(@Payload Movie movie) {
		//save movie in repo
		searchService.saveMovie(movie);
	}
}
