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
        app.setMail((String) session.getAttribute("MAIL"));
        app.setBer((String) session.getAttribute("BER"));
        app.setPho((String) session.getAttribute("PHO"));
        app.setKjnhjn((Character) session.getAttribute("KJNHJN"));
        app.setSeikj((String) session.getAttribute("SEIKJ"));
        app.setSeikn((String) session.getAttribute("SEIKN"));
        app.setSeien((String) session.getAttribute("SEIEN"));
        app.setMeikj((String) session.getAttribute("MEIKJ"));
        app.setMeikn((String) session.getAttribute("MEIKN"));
        app.setMeien((String) session.getAttribute("MEIEN"));
        app.setSex((Character) session.getAttribute("SEX"));
        app.setJkysbt((Character) session.getAttribute("JKYSBT"));
        app.setTel((String) session.getAttribute("TEL"));
        app.setPost((String) session.getAttribute("POST"));
        app.setKnc((String) session.getAttribute("KNC"));
        app.setJskj1((String) session.getAttribute("JSKJ1"));
        app.setJskj2((String) session.getAttribute("JSKJ2"));
        app.setJskn1((String) session.getAttribute("JSKN1"));
        app.setJskn2((String) session.getAttribute("JSKN2"));
        app.setSpgtorkbn((Character) session.getAttribute("SPGTORKBN"));
        app.setSpgkbn((Character) session.getAttribute("SPGKBN"));
        app.setCsgkbn((Character) session.getAttribute("CSGKBN"));
        app.setTorkbn((Character) session.getAttribute("TORKBN"));
        app.setDriverid((String) session.getAttribute("DRIVERID"));
        app.setKkhcd((String) session.getAttribute("KKHCD"));
        app.setHgsumk((Character) session.getAttribute("HGSUMK"));
        app.setKzkmlflg((Character) session.getAttribute("KZKMLFLG"));
        app.setCammlflg((Character) session.getAttribute("CAMMLFLG"));
        app.setGyocd((String) session.getAttribute("GYOCD"));
        app.setKms((String) session.getAttribute("KMS"));
        app.setKmsdep((String) session.getAttribute("KMSDEP"));
        app.setKmstel((String) session.getAttribute("KMSTEL"));
        app.setKmsjs1((String) session.getAttribute("KMSJS1"));
        app.setKmsjs2((String) session.getAttribute("KMSJS2"));
        app.setNshym((String) session.getAttribute("NSHYM"));
        app.setNsg((String) session.getAttribute("NSG"));
        return "A1A01WA01A01_入会申込情報入力";
    }




}
