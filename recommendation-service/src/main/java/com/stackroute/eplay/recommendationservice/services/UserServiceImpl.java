package com.stackroute.eplay.recommendationservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.andrewoma.dexx.collection.ArrayList;
import com.stackroute.eplay.recommendationservice.domain.City;
import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.User;
import com.stackroute.eplay.recommendationservice.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository userrepository;

	@Autowired
	public UserServiceImpl(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	public User saveUser(User user) {
		return userrepository.save(user);		
		
	}

	@Override
	public City getCityOfUser(String userName) {
		return userrepository.getCityOfUser(userName);
	}
	
//	public User getAllFollowers(String name) {
//		// TODO Auto-generated method stub
//		return (User) userrepository.findAll();
//	}	 
}
