package com.mttch.admin.server.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {

    /*
    Legacy hashing function
     */
    public static String hash(String password) {
        return DigestUtils.md5Hex(DigestUtils.md5Hex(password) + "тролушки");
    }

}
