package com.saksham.sakbot;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Token {
    public static String getToken(){
        try {
            String token = new String(Files.readAllBytes(Paths.get("token.txt")));
            if(!token.equals("")){
                return token;
            }
        } catch (Exception ignored) {
        }
        return System.getenv("TOKEN");
    }
}
