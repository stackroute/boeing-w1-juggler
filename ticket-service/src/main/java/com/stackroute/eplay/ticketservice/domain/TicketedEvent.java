package com.stackroute.eplay.ticketservice.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class TicketedEvent {
	@Id
	public int id;
	public String name;
	public Date date;
	public Date time;
	public String city;
	public String location;
	public String poster;
	public String type;
	public int capacity;
	public int remainingSeats;
	public String description;
	public String price;
	public String performers;
	public String termsAndConditions;
	public String notes;
	
	public TicketedEvent(int id, String name, Date date, Date time, String city, String location, String poster,
			String type, int capacity, int remainingSeats, String description, String price, String performers,
			String termsAndConditions, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.city = city;
		this.location = location;
		this.poster = poster;
		this.type = type;
		this.capacity = capacity;
		this.remainingSeats = remainingSeats;
		this.description = description;
		this.price = price;
		this.performers = performers;
		this.termsAndConditions = termsAndConditions;
		this.notes = notes;
	}
	
	public TicketedEvent() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPerformers() {
		return performers;
	}

	public void setPerformers(String performers) {
		this.performers = performers;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
