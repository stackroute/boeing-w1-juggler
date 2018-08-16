package com.stackroute.eplay.search.repositories;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.eplay.search.domain.Query;
import com.stackroute.eplay.search.domain.TicketedEvent;

@Repository
public interface QueryRepository extends MongoRepository<Query, Integer>{
	
}
//public interface MovieRepository extends CrudRepository<Movie, Integer>{
//	
//	@Query("FROM Movie m where m.title = :title")
//	public Optional<Movie> getMovieByTitle(@Param("title") String title);	
//}
