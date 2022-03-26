package com.example.work.services;

import com.example.work.dto.BookingRequest;
import com.example.work.models.Booking;
import com.example.work.repository.BookingRepository;
import com.example.work.validators.BookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.getBooking();
    }

    @Override
    public Booking addBooking(BookingRequest booking) throws Exception {
        BookingValidator bookingValidator = new BookingValidator(bookingRepository);
        bookingValidator.valid(booking);
        return null;

    }
}
