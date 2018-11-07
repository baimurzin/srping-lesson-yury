package com.example.srpinglesson.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UtilEncodePassword {

        // Encryte Password with BCryptPasswordEncoder
        public static String encrytePassword(String password) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.encode(password);
        }

        public static void main(String[] args) {
            String password = "user";
            String adminPass = "123456";
            String encrytedPassword = encrytePassword(password);

            System.out.println("Encryted Password: " + encrytedPassword);
        }

}
