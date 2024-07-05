package com.springdemo.flightsMVCCRUDApplication.service;

import com.springdemo.flightsMVCCRUDApplication.dao.FlightRepository;
import com.springdemo.flightsMVCCRUDApplication.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService{

    private FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository theFlightRepository){
        this.flightRepository = theFlightRepository;

    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight findById(String flightNo) {
        Optional<Flight> result = flightRepository.findById(flightNo);
        Flight flight = null;
        if(result.isPresent()){
            flight = result.get();
        }
        else{
            throw new RuntimeException("Did not find the flight No - " + flightNo);
        }
        return flight;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteById(String flightNo) {
        flightRepository.deleteById(flightNo);

    }
}
