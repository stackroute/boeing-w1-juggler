package com.stackroute.eplay.search.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Show {
	private int showId; 
	private int price; 
	private int seatRemaining; 
	private Date startTime; 
	private Date date;
}
