package com.stackroute.rsvp.repositories;

import java.util.List;


import java.util.Optional;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.rsvp.domain.RsvpCreate;

@Repository
public interface RsvpCreateRepository extends MongoRepository<RsvpCreate,String> {

}
