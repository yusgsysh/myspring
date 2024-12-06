package org.example.myspring.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.Session;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class MyController {
    @Resource
    private AppRepository appRepository;
    @RequestMapping("/")
    public String hello() {
        return "A1A01WA01A01_入会申込情報入力";
    }

    // A1A01WA01A03_入会申込情報入力.html
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

    // A1A01WA01A04_入会申込情報入力.html
    // famflg 为 家族カード付け希望
    @RequestMapping("/insert2")
    public String toInsert2(App app, HttpSession session , HttpServletRequest request) {
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
        request.setAttribute("famflg",request.getParameter("famflg"));
        return "A1A01WA01A05_入会申込情報入力";
    }

    // A1A01WA01A05_入会申込情報入力.html
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

    // A1A01WB01A01_家族カード申込情報入力.html
    @RequestMapping("/insert4")
    public String insert4(App app, HttpSession session, SessionStatus sessionStatus) {
        session.setAttribute("kzkseikj", app.getKzkseikj());
        session.setAttribute("kzkseikn",app.getKzkseikn());
        session.setAttribute("kzkseien",app.getKzkseien());
        session.setAttribute("kzksex",app.getKzksex());
        session.setAttribute("kzkgyocd",app.getKzkgyocd());
        session.setAttribute("kzkkms",app.getKzkkms());
        session.setAttribute("kzkkmsdep",app.getKzkkmsdep());
        session.setAttribute("kzkkmstel",app.getKzkkmstel());
        session.setAttribute("kzkhhucd",app.getKzkhhucd());
        return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
    }

    //判断是否为家族申请
    @RequestMapping("isFamily")
    public String isFamily(HttpServletRequest request) {
        if ("1".equals((String) request.getAttribute("famflg"))) {
            return "redirect:/A1A01WB01A01_家族カード申込情報入力";
        } else if ("0".equals((String) request.getAttribute("famflg"))) {
            return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
        }
        else return "redirect:/";
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
        app.setKzkseikj((String) session.getAttribute("kzkseikj"));
        app.setKzkseikn((String) session.getAttribute("kzkseikn"));
        app.setKzkseien((String) session.getAttribute("kzkseien"));
        app.setKzksex((Character) session.getAttribute("kzksex"));
        app.setKzkgyocd((String) session.getAttribute("kzkgyocd"));
        app.setKzkkms((String) session.getAttribute("kzkkms"));
        app.setKzkkmsdep((String) session.getAttribute("kzkkmsdep"));
        app.setKzkkmstel((String) session.getAttribute("kzkkmstel"));
        app.setKzkhhucd((Character) session.getAttribute("kzkhhucd"));
        return "A1A01WA01A01_入会申込情報入力";
    }
}
