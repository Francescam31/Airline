package com.bnta.AirlineAPI.controllers;

import com.bnta.AirlineAPI.models.Passenger;
import com.bnta.AirlineAPI.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

//    SHOW
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.findAllPassengers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> findPassengerById(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity(passengerService.findAllPassengers(), HttpStatus.CREATED);
    }








}
