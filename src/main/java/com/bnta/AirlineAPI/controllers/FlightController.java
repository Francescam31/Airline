package com.bnta.AirlineAPI.controllers;

import com.bnta.AirlineAPI.models.Flight;
import com.bnta.AirlineAPI.repositories.FlightRepository;
import com.bnta.AirlineAPI.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.CREATED);
    }





}
