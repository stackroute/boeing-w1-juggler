package com.stackroute.searchservice.repositories;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.searchservice.domain.Event;
import com.stackroute.searchservice.domain.Query;

@Repository
public interface QuerySearchServiceRepository extends MongoRepository<Query, Integer>{
	
}
//public interface MovieRepository extends CrudRepository<Movie, Integer>{
//	
//	@Query("FROM Movie m where m.title = :title")
//	public Optional<Movie> getMovieByTitle(@Param("title") String title);	
//}
