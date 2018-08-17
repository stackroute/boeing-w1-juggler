package com.stackroute.eplay.recommendationservice.domain;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Genre {
	@Id
	private int genreId;
	private String genreName;
	
	@Relationship(type = "IS_OF_GENRE", direction = Relationship.INCOMING)
	private List<Movie> movies;

	public Genre() {
		super();
	}

	public Genre(int genreId, String genreName, List<Movie> movies) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
		this.movies = movies;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
