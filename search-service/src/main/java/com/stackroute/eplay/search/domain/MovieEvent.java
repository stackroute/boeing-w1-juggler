package com.stackroute.eplay.search.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieEvent {
	private int movieEventId; 
	private int movieId; 
	private int theatreId; 
	private int showCount; 
	private Date bookingStartDate; 
	private Date bookingEndDate; 
	private List<Show> shows; 
	private String city;

}
