package com.example.work.validators;

import com.example.work.dto.BookingRequest;
import com.example.work.models.Booking;
import com.example.work.repository.BookingRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookingValidator {

    private BookingRepository bookingRepository;

    public BookingValidator(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public void valid(BookingRequest booking) throws Exception {
        List<Booking> bookingList = bookingRepository.getBooking();
        try
        {
            Date rent_start_temp = new SimpleDateFormat("dd/MM/yyyy").parse(booking.getStart());
            Date rent_end_temp = new SimpleDateFormat("dd/MM/yyyy").parse(booking.getEnd());
            boolean bookingExists = checkExsistingBooking(bookingList, rent_start_temp, rent_end_temp);

        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    private boolean checkExsistingBooking(List<Booking> bookingList, Date rent_start_temp, Date rent_end_temp) {
        boolean bookingExists = false;
        for(Booking booking1: bookingList)
        {
            if(rent_start_temp.after(booking1.getEnd()))
            {
                bookingExists = true;
            }
            if(rent_start_temp.before(booking1.getStart()) && rent_end_temp.before(booking1.getStart()))
            {
                bookingExists = true;
            }
        }
        return bookingExists;
    }
}
