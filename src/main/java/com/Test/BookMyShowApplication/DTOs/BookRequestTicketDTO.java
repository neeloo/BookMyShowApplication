package com.Test.BookMyShowApplication.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookRequestTicketDTO {
    Long userId;
    Long showId;
    List<Long> showSeatId;

}
