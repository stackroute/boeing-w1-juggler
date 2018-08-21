package com.stackroute.eplay.search.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Pojo for Show
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
	private int showId; 
	private int seatRemaining;
	private int price;
	private Date startTime; 
	private Date date;
	private int movieEventId;
	private boolean status;
	//private ArenaLayout layout;
}
