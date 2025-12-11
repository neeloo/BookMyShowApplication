package com.Test.BookMyShowApplication.DTOs;

import com.Test.BookMyShowApplication.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponseDTO {
    private User user;
    private String message;
    private ResponseStatus responseStatus;
}