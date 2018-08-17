package com.stackroute.eplay.recommendationservice.services;

import com.stackroute.eplay.recommendationservice.domain.Movie;

public interface MovieService {
	public Movie saveMovie(Movie movie);
	public Movie findByTitle(String title);
}
