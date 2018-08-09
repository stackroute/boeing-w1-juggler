package com.stackroute.eplay.upstreamservice.domain;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class TicketedEvent {

	@Id
	public String id;
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

}
