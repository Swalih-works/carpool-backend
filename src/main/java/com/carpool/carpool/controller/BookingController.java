package com.carpool.carpool.controller;

import com.carpool.carpool.model.Booking;
import com.carpool.carpool.service.BookingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public String bookRide(@RequestBody Booking booking) {
        return bookingService.bookRide(booking);
    }

    @PostMapping("/cancel/{bookingId}")
    public String cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}
