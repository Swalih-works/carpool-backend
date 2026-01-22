package com.carpool.carpool.service;

import com.carpool.carpool.model.Ride;
import com.carpool.carpool.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    // Create a ride
    public Ride createRide(Ride ride) {

        if (ride.getDriverId() == null ||
                ride.getStartLocation() == null ||
                ride.getEndLocation() == null ||
                ride.getTotalSeats() <= 0) {

            throw new RuntimeException("Invalid ride data");
        }

        ride.setAvailableSeats(ride.getTotalSeats());
        ride.setDepartureTime(LocalDateTime.now());

        return rideRepository.save(ride);
    }

    // Get all rides
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    // Search rides
    public List<Ride> searchRides(String start, String end) {
        return rideRepository.findByStartLocationAndEndLocation(start, end);
    }
}
