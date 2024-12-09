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

import static org.example.myspring.util.GetCookie.getCookie;
import static org.example.myspring.util.GetCsv.getCSV;
import static org.example.myspring.util.SaveCsv.saveCSV;

@Controller
public class MyControllerC {


    private String userToken;
    String path = "src/main/java/org/example/myspring/util/";


    @Resource
    private AppRepository appRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    //    A1A01WC01A01_お支払口座登録・変更.html
    @RequestMapping("/insert5")
    public String toInsert5(App app, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        userToken = getCookie(request, response, userToken);
//        System.out.println("app_wdc:"+app);
        session.setAttribute("bankcd", app.getBankcd());
        session.setAttribute("bchcd", app.getBchcd());
        session.setAttribute("ykn", app.getYkn());
        session.setAttribute("actcd", app.getActcd());
        session.setAttribute("actnae", app.getActnae());

        StringBuilder csvContent = new StringBuilder();
        csvContent.append("Key,Value\n");
        csvContent.append("bankcd,").append( app.getBankcd()).append("\n");
        csvContent.append("bchcd,").append( app.getBchcd()).append("\n");
        csvContent.append("ykn,").append( app.getYkn()).append("\n");
        csvContent.append("actcd,").append(app.getActcd()).append("\n");
        csvContent.append("actnae,").append(app.getActnae()).append("\n");
        saveCSV(csvContent.toString(), userToken, path);
        System.out.println(session.getAttribute("bankcd"));
        return "A1A01WC01A11_お支払口座確認";
    }

    @RequestMapping("/toA1A01WC01A01")
    public String toA1A01WB01A01(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        userToken = getCookie(request, response, userToken);
        getCSV(session, userToken, path);
        return "A1A01WC01A01_お支払口座登録・変更.html";
    }

}