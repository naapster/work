package com.example.work.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private UUID id;

    private String period;

    @OneToOne(targetEntity = Renter.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Renter renter;

    @OneToOne(targetEntity = Renter.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Renter tenant;

    private int price;

}
