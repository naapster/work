package com.example.work.repository;

import com.example.work.models.Booking;

import java.util.List;

public interface BookingRepository {

    List<Booking> getBooking();

    Booking createBook(Booking booking);

    Booking findBookingById(Long id);
}
