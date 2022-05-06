package com.example.lune.config;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class encryptUtil {
    public static String generator(String password) {
        Random random = new Random();
        int a  = random.nextInt(99999999);
        int b = random.nextInt(99999999);
        System.out.println(a);
        System.out.println(b);
        StringBuilder sb = new StringBuilder(16);
        sb.append(a).append(b);
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        System.out.println(sb);
        String salt = sb.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);




    }

    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(HexUtils.toHexString(bs));
        } catch (Exception e) {
            return null;
        }
    }

}
