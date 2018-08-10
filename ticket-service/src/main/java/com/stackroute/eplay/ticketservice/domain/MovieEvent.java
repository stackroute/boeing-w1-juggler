package com.stackroute.eplay.ticketservice.domain;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class MovieEvent {
	@Id
	private int movieEventId;
	private int movieId;
	private int theatreId;
	private int showCount;
	private Date bookingStartDate;
	private Date bookingEndDate;
	private List<Show> shows;
	private String city;
	private String userName;
	
	public MovieEvent() {
		
	}
	

	public MovieEvent(int movieEventId, int movieId, int theatreId, int showCount, Date bookingStartDate,
			Date bookingEndDate, List<Show> shows, String city) {
		super();
		this.movieEventId = movieEventId;
		this.movieId = movieId;
		this.theatreId = theatreId;
		this.showCount = showCount;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.shows = shows;
		this.userName=userName;
		this.city = city;
	}


	public int getMovieEventId() {
		return movieEventId;
	}

	public void setMovieEventId(int movieEventId) {
		this.movieEventId = movieEventId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public int getShowCount() {
		return showCount;
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public Date getBookingStartDate() {
		return bookingStartDate;
	}

	public void setBookingStartDate(Date bookingStartDate) {
		this.bookingStartDate = bookingStartDate;
	}

	public Date getBookingEndDate() {
		return bookingEndDate;
	}

	public void setBookingEndDate(Date bookingEndDate) {
		this.bookingEndDate = bookingEndDate;
	}

	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}



	
	
//	@Override
//	public boolean equals (Object o) {
//	    if (!(o instanceof MovieEvent)) {
//	        return false;
//	    }
//	    MovieEvent movieEvent = (MovieEvent)o;
//	    return  getMovieEventId()==(movieEvent.getMovieEventId()) &&
//	    		getMovieId()==(movieEvent.getMovieEventId()) &&
//	    		getTheatreId()==(movieEvent.getTheatreId()) &&
//	    		getShowCount()==(movieEvent.getShowCount()) &&
//	    		getBookingStartDate().equals(movieEvent.getBookingStartDate())&&
//	    		getBookingEndDate().equals(movieEvent.getBookingEndDate())&&
//	    		getShows().equals(movieEvent.getShows())&&
//	    		getCity().equals(movieEvent.getCity());
//
//	    		
//	}


	@Override
	public String toString() {
		return "MovieEvent [movieEventId=" + movieEventId + ", movieId=" + movieId + ", theatreId=" + theatreId
				+ ", showCount=" + showCount + ", bookingStartDate=" + bookingStartDate + ", bookingEndDate="
				+ bookingEndDate + ", shows=" + shows + ", city=" + city + "]";
	}
	
}
