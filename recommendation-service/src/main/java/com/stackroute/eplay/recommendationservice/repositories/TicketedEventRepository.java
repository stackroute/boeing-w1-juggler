package com.stackroute.eplay.recommendationservice.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.TicketedEvent;

public interface TicketedEventRepository extends Neo4jRepository<TicketedEvent,Integer > {
	
	@Query("MATCH (t:TicketedEvent) WHERE t.name ={name} RETURN t")
	TicketedEvent findByName(@Param("name") String name);
	
	@Query("Match (t:TicketedEvent) WHERE t.id ={id} RETURN t")
	TicketedEvent findById(@Param("id") int id);
}
