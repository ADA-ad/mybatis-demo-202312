package com.ada.mybatisdemo202312.exception;

public class NameNotFoundException extends RuntimeException{
    public NameNotFoundException (String message) {
        super(message);
    }
}
