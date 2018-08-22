package com.stackroute.eplay.search.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Pojo for Ticketed Event
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketedEvent {
	@Id
	private int id;
	private String name;
	private Date date;
	private Date time;
	private String city;
	private String location;
	private String poster;
	private String type;
	private int capacity;
	private int remainingSeats;
	private String description;
	private String price;
	private String performers;
	private String termsAndConditions;
	private String notes;
	private String userName;
}
