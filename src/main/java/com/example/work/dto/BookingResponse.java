package com.example.work.dto;

import com.example.work.models.ObjectRent;
import com.example.work.models.Renter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private Long id;
    private Renter owner;
    private Renter tenant;
    private ObjectRent objectRent;
    private int price;
    private String start;
    private String end;

}
