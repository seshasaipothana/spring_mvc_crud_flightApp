package com.springdemo.flightsMVCCRUDApplication.dao;

import com.springdemo.flightsMVCCRUDApplication.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,String> {
}
