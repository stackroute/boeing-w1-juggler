package com.stackroute.searchservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.searchservice.domain.Event;

@Repository
public interface EventSearchServiceRepository extends MongoRepository<Event, Integer> {
    public Iterable<Event> getEventsByCity(@Param("city") String city);

}
