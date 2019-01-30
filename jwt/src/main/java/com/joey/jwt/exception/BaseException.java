package com.joey.jwt.exception;

/**
 * @author EDZ
 * @create 2019-01-30 11:44
 * @desc BaseException
 */
public class BaseException extends RuntimeException{

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
