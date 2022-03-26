package com.example.work.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ObjectRentRepositoryImpl implements ObjectRentRepository{

    @PersistenceContext
    EntityManager entityManager;

}
