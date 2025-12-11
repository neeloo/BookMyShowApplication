package com.Test.BookMyShowApplication.models;

import com.Test.BookMyShowApplication.models.Enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    // Booking 1:M Payments
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments; // a new mapping table for it
    private int amount;
    @ManyToOne
    private User user;
    // Booking M:1 Show
    @ManyToOne
    private Show show;
    // Booking 1:M showSeats
    @OneToMany
    private List<ShowSeat> showSeats; // The seats of one/that show
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
}
