package com.stackroute.eplay.recommendationservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//	public User getAllFollowers(String name) {
//		// TODO Auto-generated method stub
//		return (User) userrepository.findAll();
//	}	 
}
