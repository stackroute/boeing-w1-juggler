package com.stackroute.eplay.search.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.eplay.search.domain.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {
    //public Iterable<Movie> getEventsByCity(@Param("city") String city);
	boolean existsById(int id);
	
	Movie findById(int id);
}
