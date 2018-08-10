package com.stackroute.eplay.search.domain;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Query {
	@Id
	private String qid;
	private String query;
	private LocalDateTime timeStamp;
	private String userId;
}
