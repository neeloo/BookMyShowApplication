package com.Test.BookMyShowApplication.DTOs;

import com.Test.BookMyShowApplication.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupResponseDTO {
    User user; // user_id
    String message;
    ResponseStatus responseStatus;
}
