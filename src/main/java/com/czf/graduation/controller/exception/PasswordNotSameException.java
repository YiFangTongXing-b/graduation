package com.czf.graduation.controller.exception;

public class PasswordNotSameException extends ControllerException{
    public PasswordNotSameException() {
    }

    public PasswordNotSameException(String message) {
        super(message);
    }

    public PasswordNotSameException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotSameException(Throwable cause) {
        super(cause);
    }

    public PasswordNotSameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
