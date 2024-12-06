package org.example.myspring.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @Resource
    private AppRepository appRepository;
    @RequestMapping("/")
    public String hello() {
        return "A1A01WA01A01_入会申込情報入力";
    }

    @RequestMapping("/insert1")
    public String toInsert1(App app, HttpSession session) {
        System.out.println("app_wdc:"+app);
        session.setAttribute("mail", app.getMail());
        session.setAttribute("ber",app.getBer());
        session.setAttribute("pho",app.getPho());
        session.setAttribute("kjnhjn",app.getKjnhjn());
        session.setAttribute("seikj",app.getSeikj());
        session.setAttribute("seikn",app.getSeikn());
        session.setAttribute("seien",app.getSeien());
        session.setAttribute("meikj",app.getMeikj());
        session.setAttribute("meikn",app.getMeikn());
        session.setAttribute("meien",app.getMeien());
        session.setAttribute("sex",app.getSex());
        System.out.println(session.getAttribute("mail"));
        System.out.println("----");
        return "A1A01WA01A04_入会申込情報入力";
//        return null;
    }
    @RequestMapping("/insert2")
    public String toInsert2(App app, HttpSession session) {
        session.setAttribute("jkysbt", app.getJkysbt());
        session.setAttribute("tel",app.getTel());
        session.setAttribute("post",app.getPost());
        session.setAttribute("knc",app.getKnc());
        session.setAttribute("jskj1",app.getJskj1());
        session.setAttribute("jskj2",app.getJskj2());
        session.setAttribute("jskn1",app.getJskn1());
        session.setAttribute("jskn2",app.getJskn2());
        session.setAttribute("spgtorkbn",app.getSpgtorkbn());
        session.setAttribute("spgkbn",app.getSpgkbn());
        session.setAttribute("csgkbn",app.getCsgkbn());
        session.setAttribute("torkbn",app.getTorkbn());
        session.setAttribute("driverid",app.getDriverid());
        session.setAttribute("kkhcd",app.getKkhcd());
        session.setAttribute("hgsumk",app.getHgsumk());
        session.setAttribute("kzkmlflg",app.getKzkmlflg());
        session.setAttribute("cammlflg",app.getCammlflg());
        return "A1A01WA01A05_入会申込情報入力";
    }
    @RequestMapping("/insert3")
    public String toInsert3(App app, HttpSession session) {
        session.setAttribute("gyocd", app.getGyocd());
        session.setAttribute("kms",app.getKms());
        session.setAttribute("kmsdep",app.getKmsdep());
        session.setAttribute("kmstel",app.getKmstel());
        session.setAttribute("kmsjs1",app.getKmsjs1());
        session.setAttribute("kmsjs2",app.getKmsjs2());
        session.setAttribute("nshym",app.getNshym());
        session.setAttribute("nsg",app.getNsg());
        return "A1A01WA01A11_入会申込情報確認";
    }

    @RequestMapping("/confirm")
    public String confirm(App app, HttpSession session){
        app.setMail((String) session.getAttribute("mail"));
        app.setBer((String) session.getAttribute("ber"));
        app.setPho((String) session.getAttribute("pho"));
        app.setKjnhjn((Character) session.getAttribute("kjnhjn"));
        app.setSeikj((String) session.getAttribute("seikj"));
        app.setSeikn((String) session.getAttribute("seikn"));
        app.setSeien((String) session.getAttribute("seien"));
        app.setMeikj((String) session.getAttribute("meikj"));
        app.setMeikn((String) session.getAttribute("meikn"));
        app.setMeien((String) session.getAttribute("meien"));
        app.setSex((Character) session.getAttribute("sex"));
        app.setJkysbt((Character) session.getAttribute("jkysbt"));
        app.setTel((String) session.getAttribute("tel"));
        app.setPost((String) session.getAttribute("post"));
        app.setKnc((String) session.getAttribute("knc"));
        app.setJskj1((String) session.getAttribute("jskj1"));
        app.setJskj2((String) session.getAttribute("jskj2"));
        app.setJskn1((String) session.getAttribute("jskn1"));
        app.setJskn2((String) session.getAttribute("jskn2"));
        app.setSpgtorkbn((Character) session.getAttribute("spgtorkbn"));
        app.setSpgkbn((Character) session.getAttribute("spgkbn"));
        app.setCsgkbn((Character) session.getAttribute("csgkbn"));
        app.setTorkbn((Character) session.getAttribute("torkbn"));
        app.setDriverid((String) session.getAttribute("driverid"));
        app.setKkhcd((String) session.getAttribute("kkhcd"));
        app.setHgsumk((Character) session.getAttribute("hgsumk"));
        app.setKzkmlflg((Character) session.getAttribute("kzkmlflg"));
        app.setCammlflg((Character) session.getAttribute("cammlflg"));
        app.setGyocd((String) session.getAttribute("gyocd"));
        app.setKms((String) session.getAttribute("kms"));
        app.setKmsdep((String) session.getAttribute("kmsdep"));
        app.setKmstel((String) session.getAttribute("kmstel"));
        app.setKmsjs1((String) session.getAttribute("kmsjs1"));
        app.setKmsjs2((String) session.getAttribute("kmsjs2"));
        app.setNshym((String) session.getAttribute("nshym"));
        app.setNsg((String) session.getAttribute("nsg"));
        return "A1A01WA01A01_入会申込情報入力";
    }




}
