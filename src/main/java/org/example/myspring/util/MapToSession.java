package org.example.myspring.util;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

public class MapToSession {
    public static void mapToSession(Map<String, String> hashMap, HttpSession session) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            session.setAttribute(entry.getKey(), entry.getValue());
        }
    }
}
