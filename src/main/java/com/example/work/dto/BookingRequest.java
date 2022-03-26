package com.example.work.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private Long ownerId;
    private Long tenantId;
    private Long objectRentId;
    private String start;
    private String end;

}
