package com.example.work.services;

import com.example.work.dto.BookingRequest;
import com.example.work.models.Booking;
import com.example.work.models.ObjectRent;
import com.example.work.repository.BookingRepository;
import com.example.work.repository.ObjectRentRepository;
import com.example.work.repository.RenterRepository;
import com.example.work.validators.BookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RenterRepository renterRepository;

    @Autowired
    ObjectRentRepository objectRentRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.getBooking();
    }

    @Override
    public Booking addBooking(BookingRequest booking) throws Exception {
        BookingValidator bookingValidator = new BookingValidator(bookingRepository, renterRepository, objectRentRepository);
        boolean valid = bookingValidator.valid(booking);
        if (!valid)
        {
            String pattern = "dd/MM/yyyy";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            ObjectRent rentObjectById = objectRentRepository.getRentObjectById(booking.getObjectRentId());
            LocalDate start = LocalDate.parse(booking.getStart(), formatter);
            LocalDate end = LocalDate.parse(booking.getEnd(), formatter);

            Period period = Period.between(start, end);
            int months = period.getMonths();
            int sum = months * rentObjectById.getPrice();
            Booking booking1 = new Booking(renterRepository.getRenterById(booking.getOwnerId()), renterRepository.getRenterById(booking.getTenantId()), rentObjectById, sum, new SimpleDateFormat("dd/MM/yyyy").parse(booking.getStart()), new SimpleDateFormat("dd/MM/yyyy").parse(booking.getEnd()));
            bookingRepository.createBook(booking1);
        }
            return null;
    }
}
