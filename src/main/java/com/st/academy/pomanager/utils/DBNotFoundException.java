package com.st.academy.pomanager.utils;

//This exception (RuntimeException) could not be the best one
public class DBNotFoundException extends RuntimeException{
    public DBNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
