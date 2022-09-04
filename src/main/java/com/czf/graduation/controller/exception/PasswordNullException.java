package com.czf.graduation.controller.exception;

public class PasswordNullException extends ControllerException{
    public PasswordNullException() {
    }

    public PasswordNullException(String message) {
        super(message);
    }

    public PasswordNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNullException(Throwable cause) {
        super(cause);
    }

    public PasswordNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
