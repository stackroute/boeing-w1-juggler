package com.stackroute.eplay.recommendationservice.services;

import java.util.List;

import com.stackroute.eplay.recommendationservice.domain.City;
import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.User;

public interface UserService {
	public User saveUser(User user);
	public List<Movie> getGenreBasedMoviesForUser(String userName);
	public List<Movie> getTypeBasedTicketedEventsForUser(String userName);
//	public User getAllFollowers(String name);
}
