package org.example.myspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

import static org.example.myspring.util.CreateID.createID;
import static org.example.myspring.util.GetCookie.getCookie;
import static org.example.myspring.util.GetCSV.getCSV;
import static org.example.myspring.util.MapToSession.mapToSession;
import static org.example.myspring.util.SaveCSV.saveCSV;

@Controller
public class MyController {

    private String userToken;
    String path = "src/main/java/org/example/myspring/util/";


    @Resource
    private AppRepository appRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/")
    public String hello(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
        return "A1A01WA01A01_入会申込情報入力";
    }

    // A1A01WA01A03_入会申込情報入力.html
    @RequestMapping("/toA1A01WA01A02")
    public String toA1A01WA01A02(HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        return "A1A01WA01A02_入会申込情報入力";
    }

    @RequestMapping("/A1A01WA01A03")
    public String toA1A01WA01A03(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
        return "A1A01WA01A03_入会申込情報入力";
    }

    @RequestMapping("/insert1")
    public String toInsert1(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
//        System.out.println("app_wdc:"+app);
        session.setAttribute("mail", app.getMail());
        session.setAttribute("ber", app.getBer());
        session.setAttribute("pho", app.getPho());
        session.setAttribute("kjnhjn", app.getKjnhjn());
        session.setAttribute("seikj", app.getSeikj());
        session.setAttribute("seikn", app.getSeikn());
        session.setAttribute("seien", app.getSeien());
        session.setAttribute("meikj", app.getMeikj());
        session.setAttribute("meikn", app.getMeikn());
        session.setAttribute("meien", app.getMeien());
        session.setAttribute("sex", app.getSex());
//        System.out.println(session.getAttribute("mail"));
//        System.out.println("----");

//        StringBuilder csvContent = new StringBuilder();
//        csvContent.append("Key,Value\n");
//        csvContent.append("mail,").append(app.getMail()).append("\n");
//        csvContent.append("ber,").append(app.getBer()).append("\n");
//        csvContent.append("pho,").append(app.getPho()).append("\n");
//        csvContent.append("kjnhjn,").append(app.getKjnhjn()).append("\n");
//        csvContent.append("seikj,").append(app.getSeikj()).append("\n");
//        csvContent.append("seikn,").append(app.getSeikn()).append("\n");
//        csvContent.append("seien,").append(app.getSeien()).append("\n");
//        csvContent.append("meikj,").append(app.getMeikj()).append("\n");
//        csvContent.append("meikn,").append(app.getMeikn()).append("\n");
//        csvContent.append("meien,").append(app.getMeien()).append("\n");
//        csvContent.append("sex,").append(app.getSex()).append("\n");
//        saveCSV(csvContent.toString(), userToken, path);
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("mail", app.getMail());
        hashMap.put("ber", app.getBer());
        hashMap.put("pho", app.getPho());
        hashMap.put("kjnhjn", String.valueOf(app.getKjnhjn()));
        hashMap.put("seikj", app.getSeikj());
        hashMap.put("seikn", app.getSeikn());
        hashMap.put("seien", app.getSeien());
        hashMap.put("meikj", app.getMeikj());
        hashMap.put("meikn", app.getMeikn());
        hashMap.put("meien", app.getMeien());
        hashMap.put("sex", String.valueOf(app.getSex()));


        return "A1A01WA01A04_入会申込情報入力";
//        return null;
    }

    // A1A01WA01A04_入会申込情報入力.html
    // famflg 为 家族カード付け希望
    // selfflg 为 本人確認書類確認方法
    @RequestMapping("/insert2")
    public String toInsert2(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
        session.setAttribute("jkysbt", app.getJkysbt());
        session.setAttribute("tel", app.getTel());
        session.setAttribute("post", app.getPost());
        session.setAttribute("knc", app.getKnc());
        session.setAttribute("jskj1", app.getJskj1());
        session.setAttribute("jskj2", app.getJskj2());
        session.setAttribute("jskn1", app.getJskn1());
        session.setAttribute("jskn2", app.getJskn2());
        session.setAttribute("spgtorkbn", app.getSpgtorkbn());
        session.setAttribute("spgkbn", app.getSpgkbn());
        session.setAttribute("csgkbn", app.getCsgkbn());
        session.setAttribute("torkbn", app.getTorkbn());
        session.setAttribute("driverid", app.getDriverid());
        session.setAttribute("kkhcd", app.getKkhcd());
        session.setAttribute("hgsumk", app.getHgsumk());
        session.setAttribute("kzkmlflg", app.getKzkmlflg());
        session.setAttribute("cammlflg", app.getCammlflg());
        session.setAttribute("famflg", request.getParameter("famflg"));
        session.setAttribute("selfflg", request.getParameter("selfflg"));

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("jkysbt", app.getJkysbt());
        hashMap.put("tel", app.getTel());
        hashMap.put("post", app.getPost());
        hashMap.put("knc", app.getKnc());
        hashMap.put("jskj1", app.getJskj1());
        hashMap.put("jskj2", app.getJskj2());
        hashMap.put("jskn1", app.getJskn1());
        hashMap.put("jskn2", app.getJskn2());
        hashMap.put("spgtorkbn", app.getSpgtorkbn());
        hashMap.put("spgkbn", app.getSpgkbn());
        hashMap.put("csgkbn", app.getCsgkbn());
        hashMap.put("torkbn", app.getTorkbn());
        hashMap.put("driverid", app.getDriverid());
        hashMap.put("kkhcd", app.getKkhcd());
        hashMap.put("hgsumk", String.valueOf(app.getHgsumk()));
        hashMap.put("kzkmlflg", String.valueOf(app.getKzkmlflg()));
        hashMap.put("cammlflg", String.valueOf(app.getCammlflg()));
        hashMap.put("famflg", request.getParameter("famflg"));
        hashMap.put("selfflg", request.getParameter("selfflg"));
        return "A1A01WA01A05_入会申込情報入力";
    }

    // A1A01WA01A05_入会申込情報入力.html
    @RequestMapping("/insert3")
    public String toInsert3(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
        session.setAttribute("gyocd", app.getGyocd());
        session.setAttribute("kms", app.getKms());
        session.setAttribute("kmsdep", app.getKmsdep());
        session.setAttribute("kmstel", app.getKmstel());
        session.setAttribute("kmsjs1", app.getKmsjs1());
        session.setAttribute("kmsjs2", app.getKmsjs2());
        session.setAttribute("nshym", app.getNshym());
        session.setAttribute("nsg", app.getNsg());
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("gyocd", app.getGyocd());
        hashMap.put("kms", app.getKms());
        hashMap.put("kmsdep", app.getKmsdep());
        hashMap.put("kmstel", app.getKmstel());
        hashMap.put("kmsjs1", app.getKmsjs1());
        hashMap.put("kmsjs2", app.getKmsjs2());
        hashMap.put("nshym", app.getNshym());
        hashMap.put("nsg", app.getNsg());

        return "A1A01WA01A11_入会申込情報確認";
    }

    // A1A01WB01A01_家族カード申込情報入力.html
    @RequestMapping("/insert4")
    public String insert4(App app, HttpSession session, SessionStatus sessionStatus, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
        session.setAttribute("kzkseikj", app.getKzkseikj());
        session.setAttribute("kzkseikn", app.getKzkseikn());
        session.setAttribute("kzkseien", app.getKzkseien());
        session.setAttribute("kzksex", app.getKzksex());
        session.setAttribute("kzkgyocd", app.getKzkgyocd());
        session.setAttribute("kzkkms", app.getKzkkms());
        session.setAttribute("kzkkmsdep", app.getKzkkmsdep());
        session.setAttribute("kzkkmstel", app.getKzkkmstel());
        session.setAttribute("kzkhhucd", app.getKzkhhucd());
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("kzkseikj", app.getKzkseikj());
        hashMap.put("kzkseikn", app.getKzkseikn());
        hashMap.put("kzkseien", app.getKzkseien());
        hashMap.put("kzksex", String.valueOf(app.getKzksex()));
        hashMap.put("kzkgyocd", app.getKzkgyocd());
        hashMap.put("kzkkms", app.getKzkkms());
        hashMap.put("kzkkmsdep", app.getKzkkmsdep());
        hashMap.put("kzkkmstel", app.getKzkkmstel());
        hashMap.put("kzkhhucd", String.valueOf(app.getKzkhhucd()));

        return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
    }

    //判断是否为家族申请
    @RequestMapping("isFamily")
    public String isFamily(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        mapToSession(getCSV(userToken, path),session);
        if ("1".equals((String) session.getAttribute("famflg"))) {
            return "redirect:/A1A01WB01A01_家族カード申込情報入力";
        } else if ("0".equals((String) session.getAttribute("famflg"))) {
            return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
        } else return "redirect:/";
    }

//    @RequestMapping("/confirm")
//    public String confirm(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
//        userToken = getCookie(request, response, userToken);
//        getCSV(session, userToken, path);
//        createID((String) session.getId());
//        app.setCstid((String) session.getId());
//        app.setMail((String) session.getAttribute("mail"));
//        app.setBer((String) session.getAttribute("ber"));
//        app.setPho((String) session.getAttribute("pho"));
//        app.setKjnhjn((Character) session.getAttribute("kjnhjn"));
//        app.setSeikj((String) session.getAttribute("seikj"));
//        app.setSeikn((String) session.getAttribute("seikn"));
//        app.setSeien((String) session.getAttribute("seien"));
//        app.setMeikj((String) session.getAttribute("meikj"));
//        app.setMeikn((String) session.getAttribute("meikn"));
//        app.setMeien((String) session.getAttribute("meien"));
//        app.setSex((Character) session.getAttribute("sex"));
//        app.setJkysbt((String) session.getAttribute("jkysbt"));
//        app.setTel((String) session.getAttribute("tel"));
//        app.setPost((String) session.getAttribute("post"));
//        app.setKnc((String) session.getAttribute("knc"));
//        app.setJskj1((String) session.getAttribute("jskj1"));
//        app.setJskj2((String) session.getAttribute("jskj2"));
//        app.setJskn1((String) session.getAttribute("jskn1"));
//        app.setJskn2((String) session.getAttribute("jskn2"));
//        app.setSpgtorkbn((String) session.getAttribute("spgtorkbn"));
//        app.setSpgkbn((String) session.getAttribute("spgkbn"));
//        app.setCsgkbn((String) session.getAttribute("csgkbn"));
//        app.setTorkbn((String) session.getAttribute("torkbn"));
//        app.setDriverid((String) session.getAttribute("driverid"));
//        app.setKkhcd((String) session.getAttribute("kkhcd"));
//        app.setHgsumk((Character) session.getAttribute("hgsumk"));
//        app.setKzkmlflg((Character) session.getAttribute("kzkmlflg"));
//        app.setCammlflg((Character) session.getAttribute("cammlflg"));
//        app.setGyocd((String) session.getAttribute("gyocd"));
//        app.setKms((String) session.getAttribute("kms"));
//        app.setKmsdep((String) session.getAttribute("kmsdep"));
//        app.setKmstel((String) session.getAttribute("kmstel"));
//        app.setKmsjs1((String) session.getAttribute("kmsjs1"));
//        app.setKmsjs2((String) session.getAttribute("kmsjs2"));
//        app.setNshym((String) session.getAttribute("nshym"));
//        app.setNsg((String) session.getAttribute("nsg"));
//        app.setKzkseikj((String) session.getAttribute("kzkseikj"));
//        app.setKzkseikn((String) session.getAttribute("kzkseikn"));
//        app.setKzkseien((String) session.getAttribute("kzkseien"));
//        app.setKzksex((Character) session.getAttribute("kzksex"));
//        app.setKzkgyocd((String) session.getAttribute("kzkgyocd"));
//        app.setKzkkms((String) session.getAttribute("kzkkms"));
//        app.setKzkkmsdep((String) session.getAttribute("kzkkmsdep"));
//        app.setKzkkmstel((String) session.getAttribute("kzkkmstel"));
//        app.setKzkhhucd((Character) session.getAttribute("kzkhhucd"));
//        return "A1A01WA01A01_入会申込情報入力";
//    }
}
