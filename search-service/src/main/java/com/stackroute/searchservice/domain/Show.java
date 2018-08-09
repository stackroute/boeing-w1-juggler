package com.stackroute.searchservice.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Show {
	@Id 
	private int showId; 
	private int price; 
	private int seatRemaining; 
	private Date startTime; 
	private Date date;
	
	public Show() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Show(int showId, int price, int seatRemaining, Date startTime, Date date) {
		super();
		this.showId = showId;
		this.price = price;
		this.seatRemaining = seatRemaining;
		this.startTime = startTime;
		this.date = date;
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
	
}
