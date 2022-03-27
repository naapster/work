package com.example.work.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private Renter owner;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Renter tenant;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private ObjectRent objectRent;

    private int price;

    @Column(name = "rent_start")
    private Date start;

    @Column(name = "rent_end")
    private Date end;

    public Booking(Renter owner, Renter tenant, ObjectRent objectRent, int price, Date start, Date end) {
        this.owner = owner;
        this.tenant = tenant;
        this.objectRent = objectRent;
        this.price = price;
        this.start = start;
        this.end = end;
    }
}
