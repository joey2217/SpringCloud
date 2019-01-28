package com.joey.user.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class Base64UtilTest {
    @Test
    public void encode() {
        String string= Base64Util.encode("123456");
        assert (string.length()>0);
    }

    @Test
    public void decode() {
        String string= Base64Util.encode("123456");
        assert (Base64Util.decode(string).equals("123456"));
    }

    @Test
    public void verifyPassword() {
        assertSame(Base64Util.encode("123456"),"123456");
    }
}
