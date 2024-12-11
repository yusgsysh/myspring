package org.example.myspring.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.example.myspring.util.GetCookie.getCookie;
import static org.example.myspring.util.GetCsv.getCSV;
import static org.example.myspring.util.SaveCsv.saveCSV;
@Controller
public class KZKController {

    private String userToken;
    String path = "src/main/java/org/example/myspring/util/";

    @Resource
    private AppRepository appRepository;

    @RequestMapping("/KZKinsert")
    public String toKZKInsert(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        userToken = getCookie(request, response, userToken);
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
        System.out.println(session.getAttribute("kzkseikj"));
//        System.out.println("----");

//        StringBuilder csvContentKSK = new StringBuilder();
//        csvContentKSK.append("Key,Value\n");
//        csvContentKSK.append("kzkseikj").append(app.getKzkseikj()).append("\n");
//        csvContentKSK.append("kzkmeikj").append(app.getKzkmeikj()).append("\n");
//        csvContentKSK.append("kzkseikn").append(app.getKzkseikn()).append("\n");
//        csvContentKSK.append("kzkmeikn").append(app.getKzkmeikn()).append("\n");
//        csvContentKSK.append("kzkseien").append(app.getKzkseien()).append("\n");
//        csvContentKSK.append("kzkmeien").append(app.getKzkmeien()).append("\n");
//        csvContentKSK.append("kzksex").append(app.getKzksex()).append("\n");
//        csvContentKSK.append("kzkgyocd").append(app.getKzkgyocd()).append("\n");
//        csvContentKSK.append("kzkkms").append(app.getKzkkms()).append("\n");
//        csvContentKSK.append("kzkkmsdep").append(app.getKzkkmsdep()).append("\n");
//        csvContentKSK.append("kzkkmstel").append(app.getKzkkmstel()).append("\n");
//        csvContentKSK.append("kzkhhucd").append(app.getKzkhhucd()).append("\n");
//        saveCSV(csvContentKSK.toString(), userToken, path);
        saveCSV(session,userToken);
        return "A1A01WB01A11_家族カード申込情報確認";
    }

    @RequestMapping("/toA1A01WB01A01")
    public String toA1A01WB01A01(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        userToken = getCookie(request, response, userToken);
        getCSV(session,userToken);
        return "A1A01WB01A01_家族カード申込情報入力";
    }

    @RequestMapping("/toA1A01WB01A11")
    public String toA1A01WB01A11(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        userToken = getCookie(request, response, userToken);
        getCSV(session,userToken);
        return "A1A01WB01A11_家族カード申込情報確認";
    }

    @RequestMapping("/toA1A01WD01A01")
    public String toA1A01WD01A01(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        userToken = getCookie(request, response, userToken);
        getCSV(session,userToken);
        return "A1A01WD01A01_本人・家族確認書類アップロード";
    }


}
