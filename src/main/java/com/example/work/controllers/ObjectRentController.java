package com.example.work.controllers;

import com.example.work.models.ObjectRent;
import com.example.work.services.ObjectRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class ObjectRentController {

    private ObjectRentService objectRentService;

    @Autowired
    public ObjectRentController(ObjectRentService objectRentService) {
        this.objectRentService = objectRentService;
    }

    @GetMapping(value = "/api/objectRent/obtainAll")
    public ResponseEntity<List<ObjectRent>> getAllObjectRents() {
        List<ObjectRent> all = objectRentService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
