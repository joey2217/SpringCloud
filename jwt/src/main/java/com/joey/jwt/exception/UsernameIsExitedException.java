package com.joey.jwt.exception;

/**
 * @author EDZ
 * @create 2019-01-30 11:46
 * @desc UsernameIsExitedException
 */
public class UsernameIsExitedException extends BaseException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}