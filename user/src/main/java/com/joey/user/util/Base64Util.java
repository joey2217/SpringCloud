package com.joey.user.util;

import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;

/**
 * @author Joey
 * @create 2019-01-28 21:18
 * @desc BASE64加密解密
 */
public class Base64Util {
    /**
     * 将 s 进行 BASE64 编码
     *
     * @return String
     */
    public static String encode(String s) {
        if (s == null) {
            return null;
        }
        String res = "";
        try {
            res = new sun.misc.BASE64Encoder().encode(s.getBytes("GBK"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 将 BASE64 编码的字符串 s 进行解码
     *
     * @return String
     */
    public static String decode(String s) {
        if (s == null) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b, "GBK");
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 验证密码
     * @param pass  数据库密码
     * @param param 参数密码
     * @return
     */
    public static boolean verifyPassword(String pass, String param) {
        if (pass == null || param == null) {
            return false;
        }
        try {
            return new sun.misc.BASE64Encoder().encode(param.getBytes("GBK")).equals(pass);
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }
}
