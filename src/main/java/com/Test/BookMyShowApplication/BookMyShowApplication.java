//package com.Test.BookMyShowApplication;
//
//import com.Test.BookMyShowApplication.DTOs.UserSignupRequestDTO;
//import com.Test.BookMyShowApplication.DTOs.UserSignupResponseDTO;
//import com.Test.BookMyShowApplication.controller.UserController;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class BookMyShowApplication implements CommandLineRunner {
//    @Autowired
//    UserController userController;
//
//	public static void main(String[] args) {SpringApplication.run(BookMyShowApplication.class, args);}
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        UserSignupRequestDTO signupRequestDTO = new UserSignupRequestDTO();
//        signupRequestDTO.setName("Neeloo Patel");
//        signupRequestDTO.setEmail("nilupate@gmail.com");
//        signupRequestDTO.setPassword("password");
//
//        UserSignupResponseDTO signUpResponseDTO = userController.signup(signupRequestDTO);
//
//        System.out.println(signUpResponseDTO.getMessage());
//
//
//    }
//}


// BookMyShowApplication.java
package com.Test.BookMyShowApplication;

import com.Test.BookMyShowApplication.Exceptions.ExistingUserException;
import com.Test.BookMyShowApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;   // Use Service, not Controller

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("=== BookMyShow Startup Test ===");

        /// Step 1: Test Signup
        try {
            userService.signup("Neeloo Patel", "neeloo@gmail.com", "mypassword123");
            System.out.println("Signup Successful!");
        } catch (Exception | ExistingUserException e) {
            System.out.println("Signup Failed: " + e.getMessage());
        }

        /// Step 2: Test Login (with correct password)
        try {
            userService.login("neeloo@gmail.com", "mypassword123");
            System.out.println("Login Successful with correct password!");
        } catch (Exception e) {
            System.out.println("Login Failed (correct pwd): " + e.getMessage());
        }

//        //// Step 3: Test Login (with wrong password) - should fail
//        try {
//            userService.login("neeloo@gmail.com", "wrongpassword");
//            System.out.println("This should NOT print");
//        } catch (Exception e) {
//            System.out.println("Login Failed with wrong password (Expected): " + e.getMessage());
//        }
//
//        // Step 4: Test Login (non-existing email)
//        try {
//            userService.login("fake@xyz.com", "anything");
//        } catch (Exception e) {
//            System.out.println("Login Failed with fake email (Expected): " + e.getMessage());
//        }
//
//        System.out.println("=== All Tests Completed ===");


    }
}
