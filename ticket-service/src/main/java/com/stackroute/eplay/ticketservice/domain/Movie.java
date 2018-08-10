package com.stackroute.eplay.ticketservice.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
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
	    public Movie() {
	    	
	    }
	    
		public Movie(int id, String name, String poster, String genre, String language, String reviews, String cast,
				String description, int rating, int duration, List<MovieEvent> movieEvents) {
			super();
			this.id = id;
			this.name = name;
			this.poster = poster;
			this.genre = genre;
			this.language = language;
			this.reviews = reviews;
			this.cast = cast;
			this.description = description;
			this.rating = rating;
			this.duration = duration;
			this.movieEvents = movieEvents;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPoster() {
			return poster;
		}

		public void setPoster(String poster) {
			this.poster = poster;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public String getLanguage() {
			return language;
		}

		public void setLanguage(String language) {
			this.language = language;
		}

		public String getReviews() {
			return reviews;
		}

		public void setReviews(String reviews) {
			this.reviews = reviews;
		}

		public String getCast() {
			return cast;
		}

		public void setCast(String cast) {
			this.cast = cast;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public List<MovieEvent> getMovieEvents() {
			return movieEvents;
		}

		public void setMovieEvents(List<MovieEvent> movieEvents) {
			this.movieEvents = movieEvents;
		}

		@Override
		public String toString() {
			return "Movie [id=" + id + ", name=" + name + ", poster=" + poster + ", genre=" + genre + ", language="
					+ language + ", reviews=" + reviews + ", cast=" + cast + ", description=" + description
					+ ", rating=" + rating + ", duration=" + duration + ", movieEvents=" + movieEvents + "]";
		}
		
		
	    
}
