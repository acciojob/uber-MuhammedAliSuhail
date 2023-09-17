package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.CabRepository;
import com.driver.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
DriverServiceImpl driverService;
@Autowired
	CabRepository cabRepository;
	@Autowired
	CustomerRepository customerRepository2;

	@Autowired
	DriverRepository driverRepository2;

	@Autowired
	TripBookingRepository tripBookingRepository2;

	@Override
	public void register(Customer customer) {
		//Save the customer in database
		customerRepository2.save(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		// Delete customer without using deleteById function
		customerRepository2.deleteById(customerId);

	}

	@Override
	public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception{
		//Book the driver with lowest driverId who is free (cab available variable is Boolean.TRUE). If no driver is available, throw "No cab available!" exception
		//Avoid using SQL query
		List<Driver> Drivers=driverRepository2.findAll();
		List<Integer> availableDrivers=new ArrayList<>();
		for(Driver driver:Drivers){
			Cab cab=driver.getCab();
			if(cab.getStatus()){
				availableDrivers.add(driver.getDriverId());
			}
		}
		Collections.sort(availableDrivers);
		Integer id=availableDrivers.get(0);
		Driver driver=driverRepository2.findById(id).get();

		Integer bill=driver.getCab().getPerKmRate()*distanceInKm;
		Customer customer=customerRepository2.findById(customerId).get();
		driver.getCab().setStatus(false);
		TripBooking tripBooking=new TripBooking(fromLocation,toLocation,distanceInKm,TripStatus.CONFIRMED,bill,customer,driver);
        tripBookingRepository2.save(tripBooking);
return tripBooking;
	}

	@Override
	public void cancelTrip(Integer tripId){
		//Cancel the trip having given trip Id and update TripBooking attributes accordingly
         TripBooking tripBooking=tripBookingRepository2.findById(tripId).get();
		 Cab cab=tripBooking.getDriver().getCab();
		 cab.setStatus(true);
		 cabRepository.save(cab);

		 tripBookingRepository2.deleteById(tripId);
	}

	@Override
	public void completeTrip(Integer tripId){
		//Complete the trip having given trip Id and update TripBooking attributes accordingly
		TripBooking tripBooking=tripBookingRepository2.findById(tripId).get();
		tripBooking.setTripStatus(TripStatus.COMPLETED);
		Cab cab=tripBooking.getDriver().getCab();
		cab.setStatus(true);
  cabRepository.save(cab);
  tripBookingRepository2.save(tripBooking);
	}
}
