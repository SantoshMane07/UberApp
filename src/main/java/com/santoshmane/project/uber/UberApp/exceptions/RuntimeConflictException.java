package com.santoshmane.project.uber.UberApp.exceptions;

public class RuntimeConflictException extends RuntimeException{
    public RuntimeConflictException(){};
    public RuntimeConflictException(String message) {
        super(message);
    }
}
