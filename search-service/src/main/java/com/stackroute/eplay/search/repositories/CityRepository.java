package com.stackroute.eplay.search.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.eplay.search.domain.City;
import com.stackroute.eplay.search.domain.Movie;
import com.stackroute.eplay.search.domain.TicketedEvent;

@Repository
public interface CityRepository extends MongoRepository<City, String> {
//    public Iterable<Movie> getEventsByCity(@Param("cityName") String cityName);

}
