package com.stackroute.eplay.search.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Pojo for Ticketed Event
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketedEvent {
	private String title;
    private	String poster;
    private String city;
}
