package com.stackroute.eplay.search.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
	@Id 
	private int id; 
	private String name; 
	private String poster; 
	private String genre; 
	private String language; 
	private String reviews; 
	private String cast; 
	private String description; 
	private int rating; 
	private int duration; 
	private List<MovieEvent> movieEvents;
}
