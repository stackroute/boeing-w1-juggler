package com.stackroute.eplay.search.domain;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private LocalTime startTime;
	private LocalDate date;
	private int movieEventId;
	private boolean status;
	//private ArenaLayout layout;
}
