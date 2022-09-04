package com.czf.graduation.controller.exception;

public class RepeatCollectException extends ControllerException{
    public RepeatCollectException() {
    }

    public RepeatCollectException(String message) {
        super(message);
    }

    public RepeatCollectException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatCollectException(Throwable cause) {
        super(cause);
    }

    public RepeatCollectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
