package com.Test.BookMyShowApplication.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignupRequestDTO {
    String name;
    String email;
    String password;
}
