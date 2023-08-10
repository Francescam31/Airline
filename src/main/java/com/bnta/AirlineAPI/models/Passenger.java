package com.bnta.AirlineAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToMany
    @JsonIgnoreProperties({"passengers"})
    @JoinTable(name = "passengers_flights", joinColumns = @JoinColumn(name = "passenger_id"),  inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private List<Flight> flights;

    public Passenger(String name, String emailAddress){
        this.name = name;
        this.emailAddress = emailAddress;
    }
    public Passenger(){}

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

//    Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
