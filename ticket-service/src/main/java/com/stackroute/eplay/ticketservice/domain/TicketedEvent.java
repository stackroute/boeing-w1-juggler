package com.stackroute.eplay.ticketservice.domain;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TicketedEvent {

    @Id
    private int id;
    private String name;
    private LocalDate date;
    private String time;
    private String city;
    private String location;
    private String poster;
    private String type;
    private int capacity;
    private int remainingSeats;
    private String description;
    private String price;
    private String performers;
    private String termsAndConditions;
    private String notes;
    private String userName;

}
