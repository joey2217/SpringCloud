package com.joey.jwt.exception;

/**
 * @author EDZ
 * @create 2019-01-30 11:45
 * @desc TokenException
 */
public class TokenException extends BaseException{
    private static final long serialVersionUID = 1L;

    public TokenException(String message) {
        super(message);
    }
}
