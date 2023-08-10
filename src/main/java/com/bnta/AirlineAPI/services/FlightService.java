package com.bnta.AirlineAPI.services;

import com.bnta.AirlineAPI.models.Flight;
import com.bnta.AirlineAPI.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public Flight saveFlight(Flight flight){
        flightRepository.save(flight);
        return flight;
    }

    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }
}
