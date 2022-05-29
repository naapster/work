package com.example.work.controllers;

import com.example.work.dto.BookingRequest;
import com.example.work.exceptions.BookingExistanceException;
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


    @GetMapping(value = "/api/booking/all")
    public ResponseEntity<List<Booking>> getAllRents() {
        List<Booking> booking = bookingService.getAllBooking();
        return new ResponseEntity<>(booking, HttpStatus.OK);

    }

    @GetMapping(value = "/api/booking/all/rent/{rentObjectId}")
    public ResponseEntity<List<Booking>> getAllRentsByObjectRentId(@PathVariable Long rentObjectId)
    {
        try
        {
            return new ResponseEntity<>(bookingService.getAllBookingByObjectRentId(rentObjectId), HttpStatus.OK);
        }
        catch (BookingExistanceException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping(value = "/api/booking/all/renter")
    public ResponseEntity<List<Booking>> getAllRentsByRenterName(@RequestParam(value="name") String name) {
        try
        {
            return new ResponseEntity<>(bookingService.getAllBookingByRenterName(name), HttpStatus.OK);
        }
        catch (BookingExistanceException e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping(value = "/api/booking/create")
    public ResponseEntity<BookingRequest> addBooking(@RequestBody BookingRequest request) {
        try
        {
            bookingService.addBooking(request);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
