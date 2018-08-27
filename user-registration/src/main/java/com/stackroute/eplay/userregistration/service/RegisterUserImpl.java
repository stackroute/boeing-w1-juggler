package com.stackroute.eplay.userregistration.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.userregistration.domain.Registration;
import com.stackroute.eplay.userregistration.domain.Theatre;
import com.stackroute.eplay.userregistration.exception.EmailAlreadyExistsException;
import com.stackroute.eplay.userregistration.exception.UserAlreadyExistsException;
import com.stackroute.eplay.userregistration.exception.UserNameAlreadyExistsException;
import com.stackroute.eplay.userregistration.repository.RegistrationRepo;


@Service
public class RegisterUserImpl implements RegisterUser {

	private RegistrationRepo registrationRepo;

	@Autowired
	public RegisterUserImpl(RegistrationRepo registrationRepo) {
		this.registrationRepo = registrationRepo;
	}

	@Autowired
	NextSequenceService nextSequenceService;
	@Override
	public Registration addUser(Registration registrant) throws UserAlreadyExistsException {
		Iterable<Registration> movies = getAllRegisterUser();
		Iterator<Registration> iterator = movies.iterator();
		
		// movie.setId(nextSequenceService.getNextSequence("counter"));
		while (iterator.hasNext()) {
			Registration oldUser = iterator.next();
			if (registrant.getUserName().equals(oldUser.getUserName())) {
				throw new UserAlreadyExistsException("User already exists");
			}
		}
	
		return registrationRepo.save(registrant);
	}
	public Iterable<Registration> getAllRegisterUser() {

		return registrationRepo.findAll();
	}
	@Override
	public Registration checkForUserName(String userName) throws UserNameAlreadyExistsException {
		Registration registrant = registrationRepo.findByUserName(userName);
		if (registrant == null)
			return registrant;
		else
			throw new UserNameAlreadyExistsException("User name already present");
	}

	@Override
	public Registration checkForEmail(String email) throws EmailAlreadyExistsException {
		Registration registrant = registrationRepo.getUserByEmail(email);
		if (registrant == null)
			return registrant;
		else
			throw new EmailAlreadyExistsException("Email already present");

	}

	@Override
	public Registration findByUsername(String userName) {
		Registration registrant = registrationRepo.findByUserName(userName);
		if (registrant == null)
			return null;
		else
			return registrant;
	}
	
	public Registration saveTheatre(Theatre theatre) {
		Registration user=findByUsername(theatre.getUserName());
		List<Theatre> theatres=user.getTheatres();
		if(theatres==null) {
			theatres=new ArrayList<Theatre>();
		}
		theatre.setTheatreId(nextSequenceService.getNextSequence("counter"));
		theatres.add(theatre);
		user.setTheatres(theatres);
		registrationRepo.save(user);
		return user;
	}
	@Override
	public Registration updateUser(Registration user, String username) {
		user.setUserName(username);
		return registrationRepo.save(user);
	}


}
