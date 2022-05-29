package com.example.work.repository;

import com.example.work.models.Booking;
import com.example.work.models.ObjectRent;

import java.util.List;

public interface ObjectRentRepository {

    ObjectRent createObject(ObjectRent objectRent);

    ObjectRent getRentObjectById(Long id);

    List<ObjectRent> obtainAllRentObject();
}
