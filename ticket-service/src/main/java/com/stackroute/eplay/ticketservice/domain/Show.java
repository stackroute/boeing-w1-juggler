package com.stackroute.eplay.ticketservice.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Show {
	@Id
	private int showId;
	private int price;
	private int seatRemaining;
	private Date startTime;
	private Date date;
	private int movieEventId;
	
	public Show() {}
	public Show(int showId, int price, int seatRemaining, Date startTime, Date date, int movieEventId) {
		super();
		this.showId = showId;
		this.price = price;
		this.seatRemaining = seatRemaining;
		this.startTime = startTime;
		this.date = date;
		this.movieEventId = movieEventId;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSeatRemaining() {
		return seatRemaining;
	}
	public void setSeatRemaining(int seatRemaining) {
		this.seatRemaining = seatRemaining;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getMovieEventId() {
		return movieEventId;
	}
	public void setMovieEventId(int movieEventId) {
		this.movieEventId = movieEventId;
	}
	@Override
	public String toString() {
		return "Show [showId=" + showId + ", price=" + price + ", seatRemaining=" + seatRemaining + ", startTime="
				+ startTime + ", date=" + date + ", movieEventId=" + movieEventId + "]";
	}
	
	
}
