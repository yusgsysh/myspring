package org.example.myspring.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.MyService;

@Controller
@RequestMapping("/card")
public class MyController {

    @Resource
    private MyService myService;

    @RequestMapping("/insert")
    public String add() {
        return add();
    }

}