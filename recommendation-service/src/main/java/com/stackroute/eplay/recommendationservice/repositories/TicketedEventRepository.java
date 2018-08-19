package com.stackroute.eplay.recommendationservice.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.eplay.recommendationservice.domain.TicketedEvent;

public interface TicketedEventRepository extends Neo4jRepository<TicketedEvent,Integer > {

}
