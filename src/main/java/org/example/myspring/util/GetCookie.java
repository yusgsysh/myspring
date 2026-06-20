package org.example.myspring.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

public class GetCookie {

    public static String getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String userToken = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userToken".equals(cookie.getName())) {
                    userToken = cookie.getValue();
                    break;
                }
            }
        }
        System.out.println("userToken: " + userToken);
        if (userToken == null) {
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("userToken", token);
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);
            userToken = token;
        }
        return userToken;
    }
}
