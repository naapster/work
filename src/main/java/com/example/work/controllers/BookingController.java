package com.example.work.controllers;

import com.example.work.dto.BookingRequest;
import com.example.work.exceptions.ParameterException;
import com.example.work.models.Booking;
import com.example.work.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping()
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping(value = "/api/all")
    public ResponseEntity<List<Booking>> getAllRents() {
        List<Booking> booking = bookingService.getAllBooking();
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping(value = "/api/create")
    public ResponseEntity<BookingRequest> addBooking(@RequestBody BookingRequest request) {
        try {
            bookingService.addBooking(request);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
