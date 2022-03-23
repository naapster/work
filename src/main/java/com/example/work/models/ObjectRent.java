package com.example.work.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "objectRent")
@AllArgsConstructor
@NoArgsConstructor
public class ObjectRent {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private int price;

    private int area;
}
