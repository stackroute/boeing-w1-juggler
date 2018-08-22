package com.stackroute.eplay.userregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.eplay.userregistration.domain.Registration;
import com.stackroute.eplay.userregistration.exception.EmailAlreadyExistsException;
import com.stackroute.eplay.userregistration.exception.UserNameAlreadyExistsException;
import com.stackroute.eplay.userregistration.repository.RegistrationRepo;

@Service
public class RegisterUserImpl implements RegisterUser {

	private RegistrationRepo registrationRepo;

	@Autowired
	public RegisterUserImpl(RegistrationRepo registrationRepo) {
		this.registrationRepo = registrationRepo;
	}

	@Override
	public Registration addUser(Registration registrant) {
		return registrationRepo.save(registrant);
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
	
	@Override
	public Registration updateUser(Registration user, String username) {
		user.setUserName(username);
		return registrationRepo.save(user);
	}

}
