package com.example.work.repository;

import com.example.work.models.ObjectRent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ObjectRentRepositoryImpl implements ObjectRentRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ObjectRent createObject(ObjectRent renter) {
            entityManager.merge(renter);
            return null;
    }

    @Override
    public ObjectRent getRentObjectById(Long id) {
        return entityManager.find(ObjectRent.class, id);
    }

    @Override
    public List<ObjectRent> obtainAllRentObject()
    {
        Query query = entityManager.createNativeQuery("select * from object_rent",  ObjectRent.class);
        List<ObjectRent> resultList = query.getResultList();

        return resultList;
    }
}
