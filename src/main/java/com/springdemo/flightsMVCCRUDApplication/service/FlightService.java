package com.springdemo.flightsMVCCRUDApplication.service;

import com.springdemo.flightsMVCCRUDApplication.model.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> findAll();
    Flight findById(String flightNo);
    Flight save(Flight flight);
    void deleteById(String flightNo);
}
