package com.stackroute.eplay.userregistration.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Model class for the User Registration
 */

@Document
public class User {
	@Id
	private String userName;
	private String password;
	private String fullName;
	private String contactNo;
	private String email;
	private String gender;
	private String city;
	private List<Theatre> theatres;
	private List<RSVPEvent> rsvpEvents;
	private List<MovieEvent> movieEvent;
	private List<TicketedEvent> ticketedEvent;

	public User() {
	}

	public User(String userName, String password, String fullName, String contactNo, String email, String gender,
			String city, List<Theatre> theatres, List<RSVPEvent> rsvpEvents, List<MovieEvent> movieEvent,
			List<TicketedEvent> ticketedEvent) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.contactNo = contactNo;
		this.email = email;
		this.gender = gender;
		this.city = city;
		this.theatres = theatres;
		this.rsvpEvents = rsvpEvents;
		this.movieEvent = movieEvent;
		this.ticketedEvent = ticketedEvent;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

	public List<RSVPEvent> getRsvpEvents() {
		return rsvpEvents;
	}

	public void setRsvpEvents(List<RSVPEvent> rsvpEvents) {
		this.rsvpEvents = rsvpEvents;
	}

	public List<MovieEvent> getMovieEvent() {
		return movieEvent;
	}

	public void setMovieEvent(List<MovieEvent> movieEvent) {
		this.movieEvent = movieEvent;
	}

	public List<TicketedEvent> getTicketedEvent() {
		return ticketedEvent;
	}

	public void setTicketedEvent(List<TicketedEvent> ticketedEvent) {
		this.ticketedEvent = ticketedEvent;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", contactNo="
				+ contactNo + ", email=" + email + ", gender=" + gender + ", city=" + city + ", theatres=" + theatres
				+ ", rsvpEvents=" + rsvpEvents + ", movieEvent=" + movieEvent + ", ticketedEvent=" + ticketedEvent
				+ "]";
	}

}
