package com.example.work.services;

import com.example.work.dto.BookingRequest;
import com.example.work.models.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> getAllBooking();

    Booking addBooking(BookingRequest booking) throws Exception;

    List<Booking> getAllBookingByObjectRentId(Long objectRentId);

    List<Booking> getAllBookingByRenterName(String renterName);
}
