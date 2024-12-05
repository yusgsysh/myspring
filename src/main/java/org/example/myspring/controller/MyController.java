package org.example.myspring.controller;

import jakarta.servlet.http.HttpSession;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("/")
    public String hello() {
        return "A1A01WA01A01_入会申込情報入力";
    }

    @RequestMapping("/insert1")
    public String toInsert1(App app, HttpSession session) {
        session.setAttribute("MAIL", app.getMail());
        session.setAttribute("BER",app.getBer());
        session.setAttribute("PHO",app.getPho());
        session.setAttribute("KJNHJN",app.getKjnhjn());
        session.setAttribute("SEIKJ",app.getSeikj());
        session.setAttribute("SEIKN",app.getSeikn());
        session.setAttribute("SEIEN",app.getSeien());
        session.setAttribute("MEIKJ",app.getMeikj());
        session.setAttribute("MEIKN",app.getMeikn());
        session.setAttribute("MEIEN",app.getMeien());
        session.setAttribute("SEX",app.getSex());
        return "A1A01WA01A04_入会申込情報入力";
    }
    @RequestMapping("/insert2")
    public String toInsert2(App app, HttpSession session) {
        session.setAttribute("JKYSBT", app.getJkysbt());
        session.setAttribute("TEL",app.getTel());
        session.setAttribute("POST",app.getPost());
        session.setAttribute("KNC",app.getKnc());
        session.setAttribute("JSKJ1",app.getJskj1());
        session.setAttribute("JSKJ2",app.getJskj2());
        session.setAttribute("JSKN1",app.getJskn1());
        session.setAttribute("JSKN2",app.getJskn2());
        session.setAttribute("SPGTORKBN",app.getSpgtorkbn());
        session.setAttribute("SPGKBN",app.getSpgkbn());
        session.setAttribute("CSGKBN",app.getCsgkbn());
        session.setAttribute("TORKBN",app.getTorkbn());
        session.setAttribute("DRIVERID",app.getDriverid());
        session.setAttribute("KKHCD",app.getKkhcd());
        session.setAttribute("HGSUMK",app.getHgsumk());
        session.setAttribute("KZKMLFLG",app.getKzkmlflg());
        session.setAttribute("CAMMLFLG",app.getCammlflg());
        return "A1A01WA01A05_入会申込情報入力";
    }
    @RequestMapping("/insert3")
    public String toInsert3(App app, HttpSession session) {
        session.setAttribute("GYOCD", app.getGyocd());
        session.setAttribute("KMS",app.getKms());
        session.setAttribute("KMSDEP",app.getKmsdep());
        session.setAttribute("KMSTEL",app.getKmstel());
        session.setAttribute("KMSJS1",app.getKmsjs1());
        session.setAttribute("KMSJS2",app.getKmsjs2());
        session.setAttribute("NSHYM",app.getNshym());
        session.setAttribute("NSG",app.getNsg());
        return "A1A01WA01A11_入会申込情報確認";
    }




}
