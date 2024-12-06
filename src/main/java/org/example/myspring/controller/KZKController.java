package org.example.myspring.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KZKController {
    @Resource
    private AppRepository appRepository;

    @RequestMapping("/KZKinsert")
    public String toKZKInsert(App app, HttpSession session) {
        session.setAttribute("kzkseikj", app.getKzkseikj());
        session.setAttribute("kzkmeikj",app.getKzkmeikj());
        session.setAttribute("kzkseikn",app.getKzkseikn());
        session.setAttribute("kzkmeikn",app.getKzkmeikn());
        session.setAttribute("kzkseien",app.getKzkseien());
        session.setAttribute("kzkmeien",app.getKzkmeien());
        session.setAttribute("kzksex",app.getKzksex());
        session.setAttribute("kzkgyocd",app.getKzkgyocd());
        session.setAttribute("kzkkms",app.getKzkkms());
        session.setAttribute("kzkkmsdep",app.getKzkkmsdep());
        session.setAttribute("kzkkmstel",app.getKzkkmstel());
        session.setAttribute("kzkhhucd",app.getKzkhhucd());
        System.out.println(session.getAttribute("kzksex"));
        System.out.println("----");
        return "A1A01WB01A11_家族カード申込情報確認";
    }

    @RequestMapping("/toA1A01WB01A01")
    public String toA1A01WB01A11(){
        return "A1A01WB01A01_家族カード申込情報入力.html";
    }
}
