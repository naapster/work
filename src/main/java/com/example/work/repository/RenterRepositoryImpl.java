package com.example.work.repository;

import com.example.work.models.Booking;
import com.example.work.models.Renter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RenterRepositoryImpl implements RenterRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Renter> getAllRenters() {
        return null;
    }

    @Override
    public Renter createRenter(Renter renter) {
        entityManager.merge(renter);
        return null;
    }

    @Override
    public Renter getRenterById(Long id) {
        return entityManager.find(Renter.class, id);
    }
}
