package com.stackroute.eplay.recommendationservice.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.eplay.recommendationservice.domain.User;

public interface UserRepository extends Neo4jRepository<User,Integer>{
	
}
