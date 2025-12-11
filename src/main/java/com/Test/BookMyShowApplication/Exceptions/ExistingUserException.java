package com.Test.BookMyShowApplication.Exceptions;

public class ExistingUserException extends Throwable {
    public ExistingUserException(String userAlreadyExists) {
        super(userAlreadyExists);
    }
}
