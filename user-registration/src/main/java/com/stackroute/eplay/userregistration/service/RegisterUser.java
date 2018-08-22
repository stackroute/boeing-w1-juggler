package com.stackroute.eplay.userregistration.service;

import com.stackroute.eplay.userregistration.domain.Registration;
import com.stackroute.eplay.userregistration.exception.EmailAlreadyExistsException;
import com.stackroute.eplay.userregistration.exception.UserNameAlreadyExistsException;

public interface RegisterUser {

	public Registration checkForUserName(String userName) throws UserNameAlreadyExistsException;

	public Registration checkForEmail(String email) throws EmailAlreadyExistsException;

	public Registration addUser(Registration registrant);

	public Registration findByUsername(String userName);
	
	public Registration updateUser(Registration user, String username);

}
