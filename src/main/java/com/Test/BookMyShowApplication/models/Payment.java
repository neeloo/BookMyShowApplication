package com.Test.BookMyShowApplication.models;

import com.Test.BookMyShowApplication.models.Enums.PaymentStatus;
import com.Test.BookMyShowApplication.models.Enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity
@Getter
public class Payment extends  BaseModel {
    private int amount;
    private String reference;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    //Payment M:1 Booking
    @ManyToOne
    private Booking booking;

}
