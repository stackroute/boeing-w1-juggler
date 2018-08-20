package com.stackroute.eplay.recommendationservice.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.stackroute.eplay.recommendationservice.domain.Genre;
import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.User;
import com.stackroute.eplay.recommendationservice.domain.UserKafka;
import com.stackroute.eplay.recommendationservice.repositories.MovieRepository;
import com.stackroute.eplay.recommendationservice.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userrepository;
	private MovieRepository movierepository;

	@Autowired
	public UserServiceImpl(UserRepository userrepository,MovieRepository movierepository) {
		this.userrepository = userrepository;
		this.movierepository = movierepository;
	}
	
	public User saveUser(User user) {
		return userrepository.save(user);		
		
	}
	
	
	public List<Movie> getGenreBasedMoviesForUser(String userName){
		return userrepository.getGenreBasedMoviesForUser(userName);
	}

	
	
/*	public List<Movie> getGenreBasedMoviesForUser(User user){
		List<Movie> moviesToBeRecommended = new ArrayList<>();
		Set<Genre> genresOfviewedMovies =new HashSet<>();
		for(Movie movie:user.getMovies()) {
			genresOfviewedMovies.add(movie.getGenre());
		}
		
		for(Genre genre :genresOfviewedMovies) {
			List<Movie> particularGenreMovies = movierepository.getMoviesByGenre(genre.toString());
			for(Movie movie :particularGenreMovies) {
				moviesToBeRecommended.add(movie);
			}	
		}
		return moviesToBeRecommended;
	}*/
//	public User getAllFollowers(String name) {
//		// TODO Auto-generated method stub
//		return (User) userrepository.findAll();
//	}	 
}
