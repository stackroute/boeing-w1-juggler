package com.stackroute.eplay.upstreamservice.domain;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Theatre {
	
	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
    private int capacity;
    private File arenaFile;
}
