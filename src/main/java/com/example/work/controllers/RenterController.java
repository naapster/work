package com.example.work.controllers;

import com.example.work.services.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rent")
public class RenterController {

    @Autowired
    private RenterService renterService;
}
