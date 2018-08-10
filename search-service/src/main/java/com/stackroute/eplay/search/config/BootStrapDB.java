package com.stackroute.eplay.search.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.eplay.search.domain.City;
import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.TicketedEvent;
import com.stackroute.eplay.search.repositories.CityRepository;
import com.stackroute.eplay.search.repositories.MovieRepository;

import org.springframework.boot.CommandLineRunner;

@Configuration
public class BootStrapDB implements ApplicationListener<ContextRefreshedEvent> {
	//public class BootStrapDB implements CommandLineRunner{
	
	
private CityRepository cityRepo;
private MovieRepository movieRepo;
    
    @Autowired
    public BootStrapDB(CityRepository cityRepo, MovieRepository movieRepo) {
        this.cityRepo = cityRepo;
        this.movieRepo = movieRepo;
    }
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
//		Movie movie1 = new Movie(1, "1", "1");
//		Movie movie2 = new Movie(2, "2", "2");
//		Movie movie3 = new Movie(3, "3", "3");
//		Movie movie4 = new Movie(4, "4", "4");
//		Movie movie5 = new Movie(5, "5", "5");
//		Movie movie6 = new Movie(6, "6", "6");
//		Movie movie7 = new Movie(7, "7", "7");
//		
//		movieRepo.save(movie1);
//		movieRepo.save(movie2);
//		movieRepo.save(movie3);
//		movieRepo.save(movie4);
//		movieRepo.save(movie5);
//		movieRepo.save(movie6);
//		movieRepo.save(movie7);
//		
//		List<Movie>list1 = new ArrayList<Movie>();
//		list1.addAll(Arrays.asList(movie1, movie2, movie3));
//		
//		List<Movie>list2 = new ArrayList<Movie>();
//		list2.addAll(Arrays.asList(movie4, movie5));
//		
//		List<Movie>list3 = new ArrayList<Movie>();
//		list3.addAll(Arrays.asList(movie6, movie7));
//		
//		City city1 = new City("delhi", list1);
//		City city2 = new City("mumbai", list2);
//		City city3 = new City("bangalore", list3);
//		
//		cityRepo.save(city1);
//		cityRepo.save(city2);
//		cityRepo.save(city3);
		
	}

}
