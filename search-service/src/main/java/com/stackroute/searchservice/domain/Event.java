package com.stackroute.searchservice.domain;

public class Event {
	private String title;
    private	String poster;
    private String city;
	public Event(String title, String poster, String city) {
		super();
		this.title = title;
		this.poster = poster;
		this.city = city;
	}
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Event(String title, String poster) {
		super();
		this.title = title;
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	@Override
	public String toString() {
		return "Event [title=" + title + ", poster=" + poster + ", city=" + city + "]";
	}

}
