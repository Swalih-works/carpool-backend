package com.carpool.carpool.repository;

import com.carpool.carpool.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {

    List<Ride> findByStartLocationAndEndLocation(String startLocation, String endLocation);

}
