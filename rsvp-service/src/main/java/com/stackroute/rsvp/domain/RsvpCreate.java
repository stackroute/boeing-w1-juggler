package com.stackroute.rsvp.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class RsvpCreate {

	@Id
    private String id;
    private String name;
    private Date startDate;
    private Date startTime;
    private Date endDate;
    private Date endTime;
    private String city;
    private String location;
    private String poster;
    private String type;
    private String description;
    private String performers;
    private String termsAndConditions;
    private String notes;
    private int numberOfAttendees;
    private boolean isCompleted;
    private List<RsvpInvitation> rsvpInvitation;
    
    
    
	public RsvpCreate(String id, String name, Date startDate, Date startTime, Date endDate, Date endTime, String city,
			String location, String poster, String type, String description, String performers,
			String termsAndConditions, String notes, List<RsvpInvitation> rsvpInvitation,
			int numberOfAttendees,boolean isCompleted) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.city = city;
		this.location = location;
		this.poster = poster;
		this.type = type;
		this.description = description;
		this.performers = performers;
		this.termsAndConditions = termsAndConditions;
		this.notes = notes;
		this.rsvpInvitation = rsvpInvitation;
		this.isCompleted=isCompleted;
		this.numberOfAttendees=numberOfAttendees;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPerformers() {
		return performers;
	}
	public void setPerformers(String performers) {
		this.performers = performers;
	}
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public List<RsvpInvitation> getRsvpInvitation() {
		return rsvpInvitation;
	}
	public void setRsvpInvitation(List<RsvpInvitation> rsvpInvitation) {
		this.rsvpInvitation = rsvpInvitation;
	}
	public int getNumberOfAttendees() {
		return numberOfAttendees;
	}
	public void setNumberOfAttendees(int numberOfAttendees) {
		this.numberOfAttendees = numberOfAttendees;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	@Override
	public String toString() {
		return "RsvpCreate [id=" + id + ", name=" + name + ", startDate=" + startDate + ", startTime=" + startTime
				+ ", endDate=" + endDate + ", endTime=" + endTime + ", city=" + city + ", location=" + location
				+ ", poster=" + poster + ", type=" + type + ", description=" + description + ", performers="
				+ performers + ", termsAndConditions=" + termsAndConditions + ", notes=" + notes
				+ ", numberOfAttendees=" + numberOfAttendees + ", isCompleted=" + isCompleted + ", rsvpInvitation="
				+ rsvpInvitation + "]";
	}
	
	
    
    
    
    
	
}
