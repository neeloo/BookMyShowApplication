package com.Test.BookMyShowApplication.service;


import com.Test.BookMyShowApplication.Exceptions.InputValidationException;
import com.Test.BookMyShowApplication.Exceptions.InvalidUserException;
import com.Test.BookMyShowApplication.Exceptions.InvalisShowException;
import com.Test.BookMyShowApplication.models.Booking;
import com.Test.BookMyShowApplication.models.Enums.BookingStatus;
import com.Test.BookMyShowApplication.models.Enums.ShowSeatStatus;
import com.Test.BookMyShowApplication.models.Show;
import com.Test.BookMyShowApplication.models.ShowSeat;
import com.Test.BookMyShowApplication.models.User;
import com.Test.BookMyShowApplication.repository.ShowRepository;
import com.Test.BookMyShowApplication.repository.ShowSeatRepository;
import com.Test.BookMyShowApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;

    public  Booking  bookTicket(Long userId, Long showId , List<Long> showSeatId) throws InputValidationException {
        //ticket booking logic
        //1-fetch user from userId  and check user  exit
        Optional<User>userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw  new InvalidUserException("use not found");
        }
        User user = userOptional.get();
        //fetch show from showId and check show validity
        Optional<Show>showOptional  = showRepository.findById(showId);
        if(showOptional.isEmpty()){
            throw  new InvalisShowException("Invalid show");
        }
        Show show = showOptional.get();
        // ----------Take lock-----------
        // 3. Fetch all the showSeats from showSeatIds and validate them
        // 4. Loop through all showSeats and check their availability
        // 5. Change the status of the showSeats to blocked
        // ----------Release Lock----------
        List<ShowSeat> showSeats = reserveSeats(showSeatId, show);

        // 6. Calculate the seat pricing - HW
        Integer totalAmount = 100;

        // 6. Create a booking with the showSeats and other data
        // HW- convert booking class into builder
        Booking booking = new Booking();
        booking.setAmount(totalAmount);
        booking.setShowSeats(showSeats);
        booking.setUser(user);
        booking.setShow(show);
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);

        // 7. Finally return the booking
        return booking;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> reserveSeats(List<Long> showSeatIds, Show show) throws InputValidationException {
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        List<ShowSeat> validatedShowSeats = showSeats
                .stream()
                .filter((showSeat) -> showSeat.getShow().getId() == show.getId())
                .toList();
        if(validatedShowSeats.isEmpty()){
            // Make it a custom one
            throw new InputValidationException("Invalid seat selection");
        }
        for(ShowSeat showSeat : validatedShowSeats){
            checkAvailability(showSeat);
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
        }
        return showSeatRepository.saveAll(validatedShowSeats);
    }

    private void checkAvailability(ShowSeat showSeat) throws InputValidationException {
        if(showSeat.getStatus().equals(ShowSeatStatus.BOOKED)){
            throw new InputValidationException("Selected seats are booked");
        }
        if(showSeat.getStatus().equals(ShowSeatStatus.BLOCKED)){
            Long timeSinceBlockedInMins = Duration.between(
                    new Date().toInstant(),
                    showSeat.getBlockedAt().toInstant()
            ).toMinutes();

            if(timeSinceBlockedInMins < 5){
                throw new InputValidationException("Selected seats are blocked");
            }
        }
    }


}
