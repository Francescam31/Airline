package com.bnta.AirlineAPI.components;

import com.bnta.AirlineAPI.models.Flight;
import com.bnta.AirlineAPI.models.Passenger;
import com.bnta.AirlineAPI.repositories.FlightRepository;
import com.bnta.AirlineAPI.repositories.PassengerRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader(){
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

//        Flight1
        Flight flight1 = new Flight("Paris", 50, "12/10/23", "12:00");
        flightRepository.save(flight1);

        Passenger passenger1 = new Passenger("Francesca", "f@gmail.com");
        passengerRepository.save(passenger1);
        Passenger passenger2 = new Passenger("Emily", "e@gmail.com");
        passengerRepository.save(passenger2);

//        Flight2
        Flight flight2 = new Flight("Rome", 30, "13/12/23", "12:15");
        flightRepository.save(flight2);

        Passenger passenger3 = new Passenger("Ian", "i@gmail.com");
        passengerRepository.save(passenger3);



    }



}
