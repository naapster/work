package com.example.work.controllers;

import com.example.work.services.ObjectRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rent_object")
public class ObjectRentController {

    @Autowired
    private ObjectRentService objectRentService;
}
