package com.Test.BookMyShowApplication.repository;

import com.Test.BookMyShowApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Explore more on the naming conventions
    Optional<User> findByEmail(String email);

}
