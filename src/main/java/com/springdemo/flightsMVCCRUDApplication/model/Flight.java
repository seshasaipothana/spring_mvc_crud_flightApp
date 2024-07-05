package com.springdemo.flightsMVCCRUDApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "flight")
public class Flight {
    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Atleast one character is required")
    @Id
    @Column(name = "flight_no")
    private String flightNo;
    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Atleast one character is required")
    @Column(name = "airlines_name")
    private String airlinesName;
    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Atleast one character is required")
    @Column(name="starting_point")
    private String startingPoint;
    @NotNull(message = "Cannot be null")
    @Size(min=1,message = "Atleast one character is required")
    @Column(name = "ending_point")
    private String endingPoint;
    @NotNull(message = "Cannot be null")
    @Min(value = 1000,message = "Must be greater than or equal to 1000")
    @Max(value = 100000,message = "Must be lesser than or equal to 100000")
    @Column(name = "price")
    private Integer ticketPrice;

    public Flight() {
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getAirlinesName() {
        return airlinesName;
    }

    public void setAirlinesName(String airlinesName) {
        this.airlinesName = airlinesName;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNo='" + flightNo + '\'' +
                ", airlinesName='" + airlinesName + '\'' +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
