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
import static org.example.myspring.util.CreateID.createID;
import static org.example.myspring.util.GetCookie.getCookie;
import static org.example.myspring.util.GetCsv.getCSV;
//import static org.example.myspring.util.SaveCsv.addCSV;
import static org.example.myspring.util.SaveCsv.saveCSV;

@Controller
public class MyController {

    private String userToken;
    String path = "src/main/java/org/example/myspring/util/";


    @Resource
    private AppRepository appRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/")
    public String hello(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
//        getCSV(session, userToken, path,"A1A01WA01A01_入会申込情報入力");
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
        getCSV(session, userToken, path,"insert1");
        return "A1A01WA01A03_入会申込情報入力";
    }

    @RequestMapping("/insert1")
    public String toInsert1(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        getCSV(session, userToken, path,"insert1");
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

        StringBuilder csvContent = new StringBuilder();
        csvContent.append("Key,Value\n");
        csvContent.append("mail,").append(app.getMail()).append("\n");
        csvContent.append("ber,").append(app.getBer()).append("\n");
        csvContent.append("pho,").append(app.getPho()).append("\n");
        csvContent.append("kjnhjn,").append(app.getKjnhjn()).append("\n");
        csvContent.append("seikj,").append(app.getSeikj()).append("\n");
        csvContent.append("seikn,").append(app.getSeikn()).append("\n");
        csvContent.append("seien,").append(app.getSeien()).append("\n");
        csvContent.append("meikj,").append(app.getMeikj()).append("\n");
        csvContent.append("meikn,").append(app.getMeikn()).append("\n");
        csvContent.append("meien,").append(app.getMeien()).append("\n");
        csvContent.append("sex,").append(app.getSex()).append("\n");
        saveCSV(csvContent.toString(), userToken, path,"insert1");
        return "A1A01WA01A04_入会申込情報入力";
//        return null;
    }

    // A1A01WA01A04_入会申込情報入力.html
    // famflg 为 家族カード付け希望
    // selfflg 为 本人確認書類確認方法
    @RequestMapping("/insert2")
    public String toInsert2(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        getCSV(session, userToken, path,"insert2");
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

        StringBuilder csvContent = new StringBuilder();
        csvContent.append("jkysbt,").append(app.getJkysbt()).append("\n");
        csvContent.append("tel,").append(app.getTel()).append("\n");
        csvContent.append("post,").append(app.getPost()).append("\n");
        csvContent.append("knc,").append(app.getKnc()).append("\n");
        csvContent.append("jskj1,").append(app.getJskj1()).append("\n");
        csvContent.append("jskj2,").append(app.getJskj2()).append("\n");
        csvContent.append("jskn1,").append(app.getJskn1()).append("\n");
        csvContent.append("jskn2,").append(app.getJskn2()).append("\n");
        csvContent.append("spgtorkbn,").append(app.getSpgtorkbn()).append("\n");
        csvContent.append("spgkbn,").append(app.getSpgkbn()).append("\n");
        csvContent.append("csgkbn,").append(app.getCsgkbn()).append("\n");
        csvContent.append("torkbn,").append(app.getTorkbn()).append("\n");
        csvContent.append("driverid,").append(app.getDriverid()).append("\n");
        csvContent.append("kkhcd,").append(app.getKkhcd()).append("\n");
        csvContent.append("hgsumk,").append(app.getHgsumk()).append("\n");
        csvContent.append("kzkmlflg,").append(app.getKzkmlflg()).append("\n");
        csvContent.append("cammlflg,").append(app.getCammlflg()).append("\n");
        csvContent.append("famflg,").append(request.getParameter("famflg")).append("\n");
        csvContent.append("selfflg,").append(request.getParameter("selfflg")).append("\n");
        saveCSV(csvContent.toString(), userToken, path,"insert2");

        return "A1A01WA01A05_入会申込情報入力";
    }

    // A1A01WA01A05_入会申込情報入力.html
    @RequestMapping("/insert3")
    public String toInsert3(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        getCSV(session, userToken, path,"insert3");
        session.setAttribute("gyocd", app.getGyocd());
        session.setAttribute("kms", app.getKms());
        session.setAttribute("kmsdep", app.getKmsdep());
        session.setAttribute("kmstel", app.getKmstel());
        session.setAttribute("kmsjs1", app.getKmsjs1());
        session.setAttribute("kmsjs2", app.getKmsjs2());
        session.setAttribute("nshym", app.getNshym());
        session.setAttribute("nsg", app.getNsg());

        StringBuilder csvContent = new StringBuilder();
        csvContent.append("gyocd,").append(app.getGyocd()).append("\n");
        csvContent.append("kms,").append(app.getKms()).append("\n");
        csvContent.append("kmsdep,").append(app.getKmsdep()).append("\n");
        csvContent.append("kmstel,").append(app.getKmstel()).append("\n");
        csvContent.append("kmsjs1,").append(app.getKmsjs1()).append("\n");
        csvContent.append("kmsjs2,").append(app.getKmsjs2()).append("\n");
        csvContent.append("nshym,").append(app.getNshym()).append("\n");
        csvContent.append("nsg,").append(app.getNsg()).append("\n");
        saveCSV(csvContent.toString(), userToken, path,"insert3");
        return "A1A01WA01A11_入会申込情報確認";
    }

    // A1A01WB01A01_家族カード申込情報入力.html
    @RequestMapping("/insert4")
    public String insert4(App app, HttpSession session, SessionStatus sessionStatus,HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
        getCSV(session, userToken, path,"insert4");
        session.setAttribute("kzkseikj", app.getKzkseikj());
        session.setAttribute("kzkseikn", app.getKzkseikn());
        session.setAttribute("kzkseien", app.getKzkseien());
        session.setAttribute("kzksex", app.getKzksex());
        session.setAttribute("kzkgyocd", app.getKzkgyocd());
        session.setAttribute("kzkkms", app.getKzkkms());
        session.setAttribute("kzkkmsdep", app.getKzkkmsdep());
        session.setAttribute("kzkkmstel", app.getKzkkmstel());
        session.setAttribute("kzkhhucd", app.getKzkhhucd());
        StringBuilder csvContent = new StringBuilder();
        csvContent.append("kzkseikj,").append(app.getKzkseikj()).append("\n");
        csvContent.append("kzkseikn,").append(app.getKzkseikn()).append("\n");
        csvContent.append("kzkseien,").append(app.getKzkseien()).append("\n");
        csvContent.append("kzksex,").append(app.getKzksex()).append("\n");
        csvContent.append("kzkgyocd,").append(app.getKzkgyocd()).append("\n");
        csvContent.append("kzkkms,").append(app.getKzkkms()).append("\n");
        csvContent.append("kzkkmsdep,").append(app.getKzkkmsdep()).append("\n");
        csvContent.append("kzkkmstel,").append(app.getKzkkmstel()).append("\n");
        csvContent.append("kzkhhucd,").append(app.getKzkhhucd()).append("\n");
        saveCSV(csvContent.toString(), userToken, path,"insert4");
        return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
    }

    //判断是否为家族申请
    @RequestMapping("isFamily")
    public String isFamily(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
//        getCSV(session, userToken, path);
        if ("1".equals((String) session.getAttribute("famflg"))) {
            return "redirect:/A1A01WB01A01_家族カード申込情報入力";
        } else if ("0".equals((String) session.getAttribute("famflg"))) {
            return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
        } else return "redirect:/";
    }

    @RequestMapping("/confirm")
    public String confirm(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
//        getCSV(session, userToken, path);
        createID((String) session.getId());
        app.setCstid((String) session.getId());
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
        app.setJkysbt((String) session.getAttribute("jkysbt"));
        app.setTel((String) session.getAttribute("tel"));
        app.setPost((String) session.getAttribute("post"));
        app.setKnc((String) session.getAttribute("knc"));
        app.setJskj1((String) session.getAttribute("jskj1"));
        app.setJskj2((String) session.getAttribute("jskj2"));
        app.setJskn1((String) session.getAttribute("jskn1"));
        app.setJskn2((String) session.getAttribute("jskn2"));
        app.setSpgtorkbn((String) session.getAttribute("spgtorkbn"));
        app.setSpgkbn((String) session.getAttribute("spgkbn"));
        app.setCsgkbn((String) session.getAttribute("csgkbn"));
        app.setTorkbn((String) session.getAttribute("torkbn"));
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
