package com.example.work.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class RenterService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RenterService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
