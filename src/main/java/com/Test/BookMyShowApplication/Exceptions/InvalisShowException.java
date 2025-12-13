package com.Test.BookMyShowApplication.Exceptions;

public class InvalisShowException extends InputValidationException {
    public InvalisShowException(String invalidShow) {
        super(invalidShow);
    }
}
