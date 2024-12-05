package org.example.myspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String hello() {
        return "A1A01WA01A01_入会申込情報入力";
    }

}
