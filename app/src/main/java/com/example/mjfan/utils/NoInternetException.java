package com.example.mjfan.utils;

/*
* Custom Exception class for handling internet connection issues*/
public class NoInternetException extends Throwable {

    public NoInternetException(String message) {
        super(message);
    }
}
