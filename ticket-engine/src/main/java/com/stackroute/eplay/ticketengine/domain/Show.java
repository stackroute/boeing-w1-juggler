package com.stackroute.eplay.ticketengine.domain;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class Show {
	@Id
	private Long showId;
	private int seatRemaining;
	private int price;
	private LocalTime startTime;
	private LocalDate date;
	private int movieEventId;
	private Boolean status;
	private ArenaLayout layout;
}
