package com.Test.BookMyShowApplication.DTOs;


import com.Test.BookMyShowApplication.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookReponseTicketDTO {
    Booking booking;
    String message;
    ResponseStatus responseStatus;


}
