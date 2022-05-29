package com.example.work.validators;

import com.example.work.dto.BookingRequest;
import com.example.work.exceptions.ParameterException;
import com.example.work.models.Booking;
import com.example.work.models.ObjectRent;
import com.example.work.models.Renter;
import com.example.work.repository.BookingRepository;
import com.example.work.repository.ObjectRentRepository;
import com.example.work.repository.RenterRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookingValidator {

    private BookingRepository bookingRepository;
    private ObjectRentRepository objectRentRepository;
    private RenterRepository renterRepository;

    public BookingValidator(BookingRepository bookingRepository, RenterRepository renterRepository, ObjectRentRepository objectRentRepository) {
        this.bookingRepository = bookingRepository;
        this.renterRepository = renterRepository;
        this.objectRentRepository = objectRentRepository;
    }

    public boolean valid(BookingRequest booking)
    {
        boolean valid;
        List<Booking> bookingList = bookingRepository.getBooking();

        validRequestParameter(booking);
        try {
            Date rent_start_temp = new SimpleDateFormat("dd/MM/yyyy").parse(booking.getStart());
            Date rent_end_temp = new SimpleDateFormat("dd/MM/yyyy").parse(booking.getEnd());

            valid = checkExistingBooking(bookingList, rent_start_temp, rent_end_temp, booking.getObjectRentId());

            databaseObjectExistingChecker(booking);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return valid;
    }

    private void databaseObjectExistingChecker(BookingRequest booking) {
        ObjectRent rentObjectById = objectRentRepository.getRentObjectById(booking.getObjectRentId());
        if (rentObjectById == null) {
            throw new ParameterException("RentObject not exist");
        }

        Renter owner = renterRepository.getRenterById(booking.getOwnerId());

        if (owner == null) {
            throw new ParameterException("owner not exist");
        }

        Renter tenant = renterRepository.getRenterById(booking.getTenantId());

        if (tenant == null) {
            throw new ParameterException("tenant not exist");
        }
    }

    private void validRequestParameter(BookingRequest booking)
    {
        if (booking != null) {
            if (booking.getObjectRentId() == null) {
                throw new ParameterException("Missing objectRentId parameter");
            }
            if (booking.getOwnerId() == null) {
                throw new ParameterException("Missing ownerId parameter");
            }
            if (booking.getTenantId() == null) {
                throw new ParameterException("Missing TenantId parameter");
            }
            if (booking.getStart() == null) {
                throw new ParameterException("Missing startDate parameter");
            }
            if (booking.getEnd() == null) {
                throw new ParameterException("Missing endDate parameter");
            }
        }
    }

    private boolean checkExistingBooking(List<Booking> bookingList, Date rent_start_temp, Date rent_end_temp, Long rentObjectId)
    {
        //TODO update checking without download all booking from database. Write sql query!!!
        List<Booking> bookingForRentObjects = bookingList.stream().filter(booking -> booking.getObjectRent().getId().equals(rentObjectId)).collect(Collectors.toList());
        for (Booking existing: bookingForRentObjects) {
            if (!(rent_start_temp.after(existing.getEnd())  || rent_end_temp.before(existing.getStart()))) {
               return true;
            }
        }
        return false;
    }
}
