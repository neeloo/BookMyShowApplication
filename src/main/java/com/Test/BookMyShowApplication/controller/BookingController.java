package com.Test.BookMyShowApplication.controller;


import com.Test.BookMyShowApplication.DTOs.BookReponseTicketDTO;
import com.Test.BookMyShowApplication.DTOs.BookRequestTicketDTO;
import com.Test.BookMyShowApplication.DTOs.ResponseStatus;
import com.Test.BookMyShowApplication.Exceptions.InputValidationException;
import com.Test.BookMyShowApplication.models.Booking;
import com.Test.BookMyShowApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    BookService bookService;

    BookReponseTicketDTO bookTicket(BookRequestTicketDTO requestDto) {
        BookReponseTicketDTO reponceDTO = new BookReponseTicketDTO();
        try {
            Booking booking = bookService.bookTicket(requestDto.getUserId()
                    , requestDto.getShowId(), requestDto.getShowSeatId());
            reponceDTO.setBooking(booking);
            reponceDTO.setMessage("Booking successful");
            reponceDTO.setResponseStatus(ResponseStatus.SUCCESS);

        }
        catch (InputValidationException e) {
            System.out.println("booking  input failed the validation:" + e.getMessage());
            reponceDTO.setResponseStatus(ResponseStatus.FAILURE);
            reponceDTO.setMessage("input validation is failed:" + e.getMessage());

        }
        catch (Exception e) {
            System.out.println("Failure is booking:" + e.getMessage());
            reponceDTO.setResponseStatus(ResponseStatus.FAILURE);
            reponceDTO.setMessage("failed booking");
        }

        return reponceDTO;
    }

}
