package com.example.work.repository;

import com.example.work.models.Renter;

import java.util.List;

public interface RenterRepository {

    List<Renter> getAllRenters();

    Renter createRenter(Renter renter);
}
