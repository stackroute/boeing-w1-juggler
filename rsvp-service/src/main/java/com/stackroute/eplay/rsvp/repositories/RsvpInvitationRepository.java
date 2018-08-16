package com.stackroute.eplay.rsvp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.eplay.rsvp.domain.Invitation;

@Repository
public interface RsvpInvitationRepository extends MongoRepository<Invitation,Integer> {

}
