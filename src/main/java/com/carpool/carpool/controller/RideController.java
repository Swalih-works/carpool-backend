package com.carpool.carpool.controller;

import com.carpool.carpool.model.Ride;
import com.carpool.carpool.service.RideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    // Create ride
    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }

    // Get all rides
    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    // Search rides
    @GetMapping("/search")
    public List<Ride> searchRides(
            @RequestParam String start,
            @RequestParam String end) {

        return rideService.searchRides(start, end);
    }
}
