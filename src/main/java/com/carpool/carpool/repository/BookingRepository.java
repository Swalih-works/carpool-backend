package com.carpool.carpool.repository;

import com.carpool.carpool.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}