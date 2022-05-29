package com.example.work.repository;

import com.example.work.models.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> getBooking();

    List<Booking> getBookingByObjectRentId(Long id);

    List<Booking> getBookingByRenterName(String name);

    Booking createBook(Booking booking);

    Booking findBookingById(Long id);
}
