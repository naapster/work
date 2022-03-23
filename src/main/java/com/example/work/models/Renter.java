package com.example.work.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "renter")
@AllArgsConstructor
@NoArgsConstructor
public class Renter {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
