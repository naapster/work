package com.example.work;

import com.example.work.models.Booking;
import com.example.work.models.ObjectRent;
import com.example.work.models.Renter;
import com.example.work.repository.BookingRepository;
import com.example.work.repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class Start {

    private BookingRepository bookingRepository;
    private RenterRepository renterRepository;


    @Autowired
    public Start(BookingRepository bookingRepository, RenterRepository renterRepository) {
        this.bookingRepository = bookingRepository;
        this.renterRepository = renterRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void example()
    {
        Renter owner = new Renter(1L, "Michal");
        Renter owner2= new Renter(2L, "Mateusz");
        Renter renter = new Renter(3L, "Karina");
        Renter renter2 = new Renter(4L, "Robert");

        renterRepository.createRenter(owner);
        renterRepository.createRenter(owner2);
        renterRepository.createRenter(renter);
        renterRepository.createRenter(renter2);

        ObjectRent objectRent1 = new ObjectRent(1L, "house1", 1000, 100);
        ObjectRent objectRent2 = new ObjectRent(2L, "house2", 1500, 150);
        Booking booking = new Booking(1L, owner, renter, objectRent1, 2000, Date.valueOf(LocalDate.of(2022, 1, 23)), Date.valueOf(LocalDate.of(2022, 3, 29)));
        Booking booking1 = new Booking(2L, owner2, renter2, objectRent2, 3000, Date.valueOf(LocalDate.of(2022, 1, 15)), Date.valueOf(LocalDate.of(2022, 3, 18)));
        Booking booking2 = new Booking(3L, owner2, renter2, objectRent2, 3000, Date.valueOf(LocalDate.of(2022, 1, 15)), Date.valueOf(LocalDate.of(2022, 3, 15)));
        bookingRepository.createBook(booking);
        bookingRepository.createBook(booking1);
        bookingRepository.createBook(booking2);
    }

}
