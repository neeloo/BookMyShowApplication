package com.Test.BookMyShowApplication.Exceptions;

public class InvalidUserException extends  InputValidationException{
    public InvalidUserException(String userAlreadyExists) {
        super(userAlreadyExists);
    }
}
