package com.Test.BookMyShowApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity //(name="bms_user")
@Setter
@Getter
public class User extends BaseModel {
    private String name;
    private String email;
    // User 1:M Booking
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
    private String password;
}
