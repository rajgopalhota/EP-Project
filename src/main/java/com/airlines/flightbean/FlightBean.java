package com.airlines.flightbean;

import java.util.List;

import javax.ejb.Remote;

import com.airlines.flightentity.Flight;
@Remote
public interface FlightBean {
	public String insertData(Flight e) throws Exception;
	public List<Flight> getFlightData() throws Exception;
}
