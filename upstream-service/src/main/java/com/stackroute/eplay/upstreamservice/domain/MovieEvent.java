package com.stackroute.eplay.upstreamservice.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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
	
}
