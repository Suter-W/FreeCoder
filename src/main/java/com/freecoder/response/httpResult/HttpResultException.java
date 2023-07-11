package com.freecoder.response.httpResult;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpResultException extends Exception {
    private HttpStatus httpStatus;

    public HttpResultException() {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpResultException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpResultException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpResultException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}

