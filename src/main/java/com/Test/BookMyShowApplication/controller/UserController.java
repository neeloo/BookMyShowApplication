package com.Test.BookMyShowApplication.controller;

import com.Test.BookMyShowApplication.DTOs.ResponseStatus;
import com.Test.BookMyShowApplication.DTOs.UserSignupRequestDTO;
import com.Test.BookMyShowApplication.DTOs.UserSignupResponseDTO;
import com.Test.BookMyShowApplication.models.User;
import com.Test.BookMyShowApplication.Exceptions.ExistingUserException;
import com.Test.BookMyShowApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    public UserSignupResponseDTO signup(UserSignupRequestDTO requestDTO){
        UserSignupResponseDTO responseDTO = new UserSignupResponseDTO();
        try{
            User user = userService.signup(requestDTO.getName(),
                    requestDTO.getEmail(), requestDTO.getPassword());
            responseDTO.setUser(user);
            responseDTO.setMessage("User signup is successfull");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);


        }catch(Exception | ExistingUserException e){
            System.out.println("[UserController.signup] User Signup :" + e.getMessage());
            responseDTO.setMessage("User signup failed");
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return  responseDTO;
    }
}

// Registry { "UserController" -> userControllerObject,"UserService" -> userServiceObject }