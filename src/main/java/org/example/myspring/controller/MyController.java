package org.example.myspring.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.example.myspring.util.CreateID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MyController {

    private String userToken;
    File directory = new File("src/main/java/org/example/myspring/util/");

    @Resource
    private AppRepository appRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @RequestMapping("/")
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        this.getCookie(request,response);
        return "A1A01WA01A01_入会申込情報入力";
    }

    // A1A01WA01A03_入会申込情報入力.html
    @RequestMapping("/toA1A01WA01A02")
    public String toA1A01WA01A02(HttpServletRequest request, HttpServletResponse response) {
        this.getCookie(request,response);
        return "A1A01WA01A02_入会申込情報入力";
    }

    @RequestMapping("/A1A01WA01A03")
    public String toA1A01WA01A03(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        this.getCookie(request,response);
        getCSV(session);
        return "A1A01WA01A03_入会申込情報入力";
    }

    @RequestMapping("/insert1")
    public String toInsert1(App app, HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        this.getCookie(request,response);
//        System.out.println("app_wdc:"+app);
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
        saveCSV(csvContent.toString());
        return "A1A01WA01A04_入会申込情報入力";
//        return null;
    }

    // A1A01WA01A04_入会申込情報入力.html
    // famflg 为 家族カード付け希望
    @RequestMapping("/insert2")
    public String toInsert2(App app, HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        this.getCookie(request,response);
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
//        session.setAttribute("famflg", request.getParameter("famflg"));
        return "A1A01WA01A05_入会申込情報入力";
    }

    // A1A01WA01A05_入会申込情報入力.html
    @RequestMapping("/insert3")
    public String toInsert3(App app, HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        this.getCookie(request,response);
        session.setAttribute("gyocd", app.getGyocd());
        session.setAttribute("kms", app.getKms());
        session.setAttribute("kmsdep", app.getKmsdep());
        session.setAttribute("kmstel", app.getKmstel());
        session.setAttribute("kmsjs1", app.getKmsjs1());
        session.setAttribute("kmsjs2", app.getKmsjs2());
        session.setAttribute("nshym", app.getNshym());
        session.setAttribute("nsg", app.getNsg());
        return "A1A01WA01A11_入会申込情報確認";
    }

    // A1A01WB01A01_家族カード申込情報入力.html
    @RequestMapping("/insert4")
    public String insert4(App app, HttpSession session, SessionStatus sessionStatus) {
        session.setAttribute("kzkseikj", app.getKzkseikj());
        session.setAttribute("kzkseikn", app.getKzkseikn());
        session.setAttribute("kzkseien", app.getKzkseien());
        session.setAttribute("kzksex", app.getKzksex());
        session.setAttribute("kzkgyocd", app.getKzkgyocd());
        session.setAttribute("kzkkms", app.getKzkkms());
        session.setAttribute("kzkkmsdep", app.getKzkkmsdep());
        session.setAttribute("kzkkmstel", app.getKzkkmstel());
        session.setAttribute("kzkhhucd", app.getKzkhhucd());
        return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
    }

    //判断是否为家族申请
    @RequestMapping("isFamily")
    public String isFamily(HttpSession session) {
        if ("1".equals((String) session.getAttribute("famflg"))) {
            return "redirect:/A1A01WB01A01_家族カード申込情報入力";
        } else if ("0".equals((String) session.getAttribute("famflg"))) {
            return "redirect:/A1A01WD01A01_本人・家族確認書類アップロード";
        } else return "redirect:/";
    }

    @RequestMapping("/confirm")
    public String confirm(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        this.getCookie(request,response);
        CreateID.createID((String) session.getId());
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

    /**
     * 获取当前用户cookid
     * @param request
     * @param response
     * @return this.userToken
     */
    public void getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("userToken".equals(cookie.getName())) {
                this.userToken = cookie.getValue();
            }
        }
        System.out.println(userToken);
        if (this.userToken == null) {
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("userToken",token);
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);
            this.userToken = token;
        }
    }
    public void saveCSV(String csvContent) {
        // 写入CSV文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory.getAbsolutePath() + "/" + this.userToken + ".csv"))) {
            writer.write(csvContent.toString());
            System.out.println("Success wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getCSV(HttpSession session){
        File file = new File(directory.getAbsolutePath() + "/" + this.userToken + ".csv");
        if (file.exists()){
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        session.setAttribute(parts[0].trim(), parts[1].trim());
                    }
                }
                System.out.println(session.getAttribute("mail"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return;
        }

    }
}
