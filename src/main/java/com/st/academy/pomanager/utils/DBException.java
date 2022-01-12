package com.st.academy.pomanager.utils;

//This exception (RuntimeException) could not be the best one
public class DBException extends RuntimeException{
    public DBException(String errorMessage) {
        super(errorMessage);
    }
}
