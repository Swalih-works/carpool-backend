package com.carpool.carpool.service;

import com.carpool.carpool.model.Booking;
import com.carpool.carpool.model.Ride;
import com.carpool.carpool.repository.BookingRepository;
import com.carpool.carpool.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RideRepository rideRepository;

    public BookingService(BookingRepository bookingRepository,
                          RideRepository rideRepository) {
        this.bookingRepository = bookingRepository;
        this.rideRepository = rideRepository;
    }

    // Book a ride
    public String bookRide(Booking booking) {

        Optional<Ride> rideOptional = rideRepository.findById(booking.getRideId());

        if (rideOptional.isEmpty()) {
            return "Ride not found";
        }

        Ride ride = rideOptional.get();

        if (ride.getAvailableSeats() <= 0) {
            return "No seats available";
        }

        ride.setAvailableSeats(ride.getAvailableSeats() - 1);
        rideRepository.save(ride);

        booking.setStatus("BOOKED");
        bookingRepository.save(booking);

        return "Booking successful";
    }

    // Cancel booking
    public String cancelBooking(Long bookingId) {

        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);

        if (bookingOptional.isEmpty()) {
            return "Booking not found";
        }

        Booking booking = bookingOptional.get();

        if ("CANCELLED".equals(booking.getStatus())) {
            return "Booking already cancelled";
        }

        Optional<Ride> rideOptional = rideRepository.findById(booking.getRideId());

        if (rideOptional.isEmpty()) {
            return "Ride not found";
        }

        Ride ride = rideOptional.get();

        ride.setAvailableSeats(ride.getAvailableSeats() + 1);
        rideRepository.save(ride);

        booking.setStatus("CANCELLED");
        bookingRepository.save(booking);

        return "Booking cancelled successfully";
    }
}
