package com.stackroute.searchservice.domain;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class Query {
	@Id
	private String qid;
	private String query;
	private LocalDateTime timeStamp;
	private String userId;
	public Query(String query, LocalDateTime timeStamp, String userId, String qid) {
		super();
		this.query = query;
		this.timeStamp = timeStamp;
		this.userId = userId;
	}
	public Query() {
		// TODO Auto-generated constructor stub
	}
	public String getQid() {
		return qid;
	}
	public void setQid(String qid) {
		this.qid = qid;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Query [qid=" + qid + ", query=" + query + ", timeStamp=" + timeStamp + ", userId=" + userId + "]";
	}
	

}
