package com.Test.BookMyShowApplication.controller;

import com.Test.BookMyShowApplication.DTOs.ResponseStatus;
import com.Test.BookMyShowApplication.DTOs.UserLoginRequestDTO;
import com.Test.BookMyShowApplication.DTOs.UserLoginResponseDTO;
import com.Test.BookMyShowApplication.models.User;
import com.Test.BookMyShowApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
//    @Autowired
//    UserService userService;
//    /// use login page
//    public UserLoginResponseDTO login(UserLoginRequestDTO dto) {
//
//        UserLoginResponseDTO response = new UserLoginResponseDTO();
//
//        try {
//            User user = userService.login(dto.getEmail(), dto.getPassword());
//            response.setUser(user);
//            response.setMessage("Login successful");
//            response.setResponseStatus(ResponseStatus.SUCCESS);
//
//        } catch (Exception e) {
//            response.setMessage("Invalid email or password");
//            response.setResponseStatus(ResponseStatus.FAILURE);
//        }
//        return response;
//    }
}
