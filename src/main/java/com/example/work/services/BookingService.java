package com.example.work.services;

import com.example.work.models.Booking;
import com.example.work.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class BookingService {

    @Autowired
   private EntityManager bookingRepository;



    public List<Booking> getAllBooking()
    {
        String query = "from " + Booking.class.getSimpleName();
        Query query1 = bookingRepository.createQuery(query);
        return query1.getResultList();
    }
}
