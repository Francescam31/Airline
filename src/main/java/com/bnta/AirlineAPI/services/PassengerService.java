package com.bnta.AirlineAPI.services;

import com.bnta.AirlineAPI.models.Passenger;
import com.bnta.AirlineAPI.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public Passenger savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
        return passenger;
    }

    public List<Passenger> findAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger findPassenger(Long id){
        return passengerRepository.findById(id).get();
    }

}
