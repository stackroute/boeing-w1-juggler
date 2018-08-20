package com.stackroute.eplay.recommendationservice.repositories;


import java.util.List;


import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;


import com.stackroute.eplay.recommendationservice.domain.City;
import com.stackroute.eplay.recommendationservice.domain.User;
import com.stackroute.eplay.recommendationservice.domain.Movie;
import com.stackroute.eplay.recommendationservice.domain.User;

public interface UserRepository extends Neo4jRepository<User,Integer>{
	
	@Query("MATCH (u:User)-[:LIVES_IN]->(c:City) where u.userName={userName} return c")
	public City getCityOfUser(@Param("userName") String userName);

	@Query("Match (u:User)-[:VIEWED]->(m:Movie)-[:IS_OF_GENRE]->(g:Genre)<-[:IS_OF_GENRE]-(r:Movie) where u.userName= {userName} Match (r)-[:RELEASED_IN]->(c:City)<-[:LIVES_IN]-(u) return (r)")
    public List<Movie> getGenreBasedMoviesForUser(@Param("userName") String userName);

}
