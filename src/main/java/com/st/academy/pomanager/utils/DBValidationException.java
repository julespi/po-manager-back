package com.st.academy.pomanager.utils;

//This exception (RuntimeException) could not be the best one
public class DBValidationException extends RuntimeException{
    public DBValidationException(String errorMessage) {
        super(errorMessage);
    }
}
