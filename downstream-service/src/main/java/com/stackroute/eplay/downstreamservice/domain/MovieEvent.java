package com.stackroute.eplay.downstreamservice.domain;

import java.io.File;
import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
public class MovieEvent {
	
	@Id
	private String movieEventId;
	private String movieId;
	private String theatreId;
	private int showCount;
	private Date bookingStartDate;
	private Date bookingEndDate;
	private List<Show> shows;
	private String city;
	public String getMovieEventId() {
		return movieEventId;
	}
	public void setMovieEventId(String movieEventId) {
		this.movieEventId = movieEventId;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public int getShowCount() {
		return showCount;
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
	public MovieEvent() {}
	public MovieEvent(String movieEventId, String movieId, String theatreId, int showCount, Date bookingStartDate,
			Date bookingEndDate, List<Show> shows, String city) {
		super();
		this.movieEventId = movieEventId;
		this.movieId = movieId;
		this.theatreId = theatreId;
		this.showCount = showCount;
		this.bookingStartDate = bookingStartDate;
		this.bookingEndDate = bookingEndDate;
		this.shows = shows;
		this.city = city;
	}

}
