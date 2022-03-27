package com.example.work.repository;

import com.example.work.models.ObjectRent;

import java.util.List;

public interface ObjectRentRepository {

    List<ObjectRent> getAllRentObjects();

    ObjectRent createObject(ObjectRent objectRent);

    ObjectRent getRentObjectById(Long id);
}
