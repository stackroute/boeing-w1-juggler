package com.stackroute.eplay.recommendationservice.domain;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {
	@Id
	private int userId;
	private String name;
	private int age;
	@Relationship(type = "VIEWED", direction = Relationship.OUTGOING)
	private List<Movie> movies;
	
//	@Relationship(type="FOLLOWS",direction = Relationship.OUTGOING)
//	private List<User> users;
//	
//	@Relationship(type="FOLLOWED_BY",direction = Relationship.INCOMING)
//	private List<User> otherUsers;

	public User() {
		super();
	}

	public User(int userId, String name, int age) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
	}

	public void viewed(Movie movie) {
		this.movies.add(movie);
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	
	
}
