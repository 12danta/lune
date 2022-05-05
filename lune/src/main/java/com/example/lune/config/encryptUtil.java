package com.example.lune.config;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class encryptUtil {
    public static void generator() {
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
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
