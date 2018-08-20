package com.stackroute.eplay.recommendationservice.domain;

import org.neo4j.ogm.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	@Id
	private String categoryName;
}
