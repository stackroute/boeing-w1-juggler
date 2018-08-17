package com.stackroute.eplay.recommendationservice.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.eplay.recommendationservice.domain.City;

public interface CityRepository extends Neo4jRepository<City,Long> {

}
