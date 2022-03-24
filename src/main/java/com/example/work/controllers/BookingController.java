package com.example.work.controllers;

import com.example.work.models.Booking;
import com.example.work.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;


    @GetMapping
    public ResponseEntity<?> getAllRents() {
        try {
            List<Booking> rentList = bookingService.getAllBooking();
            return new ResponseEntity<>(rentList, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No booking to display"
            );
        }
    }
}
