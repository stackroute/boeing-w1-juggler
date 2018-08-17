package com.stackroute.eplay.recommendationservice.domain;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NodeEntity
public class Movie {
	@Id
	private int movieId;
	private String title;
	private String language;
	private Double rating;
	
	@Relationship(type="RELEASED_IN",direction=Relationship.OUTGOING)
	private List<City> cities ;
	
	@JsonIgnoreProperties("movie")
	@Relationship(type="VIEWED",direction=Relationship.INCOMING)
	private List<User> user;
		
	public Movie() {
		
	}
	public void releasedIn(City city) {
		cities.add(city);
	}
	public Movie(int movieId, String title, String language, Double rating) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.language = language;
		this.rating = rating;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public List<City> getCities() {
		return cities;
	}
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
}
