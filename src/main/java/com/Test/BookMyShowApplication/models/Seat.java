package com.Test.BookMyShowApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;
    // Seat M:1 SeatType
    @ManyToOne
    private SeatType seatType; // GOLD
    private int row;
    private int col;
}
