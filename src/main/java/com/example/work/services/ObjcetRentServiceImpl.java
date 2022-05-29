package com.example.work.services;

import com.example.work.models.Booking;
import com.example.work.models.ObjectRent;
import com.example.work.repository.ObjectRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjcetRentServiceImpl implements ObjectRentService {

    @Autowired
    ObjectRentRepository objectRentRepository;

    @Override
    public List<ObjectRent> getAll() {
        return objectRentRepository.obtainAllRentObject();
    }
}
