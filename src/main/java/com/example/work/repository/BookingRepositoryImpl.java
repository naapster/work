package com.example.work.repository;

import com.example.work.models.Booking;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookingRepositoryImpl implements BookingRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Booking> getBooking() {
        Query query = entityManager.createNativeQuery("select * from booking",  Booking.class);
        List<Booking> resultList = query.getResultList();

        return resultList;
    }

    public List<Booking> getBookingByObjectRentId(Long id)
    {
        Query query = entityManager.createNativeQuery("select * from booking where object_rent_id = :id",  Booking.class);
        query.setParameter("id", id);
        List<Booking> resultList = query.getResultList();

        return resultList;
    }

    public List<Booking> getBookingByRenterName(String name)
    {
//        Query query = entityManager.createNativeQuery("select * from booking join renter on booking.id = renter.id where renter.name = :name",  Booking.class);
        Query query = entityManager.createNativeQuery("select * from booking b join renter r on b.tenant_id = r.id where r.name = :name",  Booking.class);
        query.setParameter("name", name);
        List<Booking> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public Booking createBook(Booking booking)
    {
        entityManager.merge(booking);
        return null;
    }

    @Override
    public Booking findBookingById(Long id) {
        return entityManager.find(Booking.class, id);
    }
}
