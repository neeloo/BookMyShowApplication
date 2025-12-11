package com.Test.BookMyShowApplication.controller;

import com.Test.BookMyShowApplication.DTOs.*;
import com.Test.BookMyShowApplication.models.User;
import com.Test.BookMyShowApplication.Exceptions.ExistingUserException;
import com.Test.BookMyShowApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    /// use signup page
    public UserSignupResponseDTO signup(UserSignupRequestDTO requestDTO) {

        UserSignupResponseDTO responseDTO = new UserSignupResponseDTO();

        try {
            User user = userService.signup(requestDTO.getName(),
                    requestDTO.getEmail(),
                    requestDTO.getPassword());
            responseDTO.setUser(user);
            responseDTO.setMessage("User signup is successfully");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);


        } catch (Exception | ExistingUserException e) {
            System.out.println("[UserController.signup] User Signup :" + e.getMessage());
            responseDTO.setMessage("User signup failed");
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }

    /// use login page
    public UserLoginResponseDTO login(UserLoginRequestDTO dto) {

        UserLoginResponseDTO response = new UserLoginResponseDTO();

        try {
            User user = userService.login(dto.getEmail(), dto.getPassword());
            response.setUser(user);
            response.setMessage("Login successful");
            response.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (Exception e) {
            response.setMessage("Invalid email or password");
            response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}

// Registry { "UserController" -> userControllerObject,"UserService" -> userServiceObject }