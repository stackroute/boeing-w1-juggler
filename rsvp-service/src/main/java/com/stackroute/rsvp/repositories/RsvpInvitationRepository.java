package com.stackroute.rsvp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.rsvp.domain.RsvpInvitation;

@Repository
public interface RsvpInvitationRepository extends MongoRepository<RsvpInvitation,String> {

}
