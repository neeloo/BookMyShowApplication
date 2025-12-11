package com.Test.BookMyShowApplication.service;

import com.Test.BookMyShowApplication.Exceptions.ExistingUserException;
import com.Test.BookMyShowApplication.models.User;
import com.Test.BookMyShowApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User signup(String name, String email, String password) throws ExistingUserException {
        // We check if user exists or not
        Optional<User> userOptional = userRepository.findByEmail(email);
        // If user exists - Then throw exception - users already exists
        if(userOptional.isPresent()){
            throw new ExistingUserException("User already exists");
        }
        // If user doesn't exist - we create a user and save in the database
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        // Encode means hashing not encryption -> Hash can be matched with original string but you can't get back the original string from hash
        user.setPassword(bCryptPasswordEncoder.encode(password));

        // return the user
        return userRepository.save(user);
    }
}
