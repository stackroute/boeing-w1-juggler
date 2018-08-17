package com.stackroute.eplay.recommendationservice.services;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.repositories.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movierepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movierepository) {
		super();
		this.movierepository = movierepository;
	}

	public Movie saveMovie(Movie movie) {
		return movierepository.save(movie);
	}
	
	public Movie findByTitle(String title) {
		return movierepository.findByTitle(title);
    }

}
