package org.example.myspring.util;

import jakarta.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

public class SaveCsv {

    public static void saveCSV(HttpSession session, String userToken) {
        String FILEPATH = "src/main/java/org/example/myspring/util/";
        File directory = new File(FILEPATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(directory.getAbsolutePath() + "/" + userToken + ".csv");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, !file.exists()))) {
            // 获取所有session属性名称
            Enumeration<String> attributeNames = session.getAttributeNames();

            // 写入CSV文件的头部
            boolean first = true;
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                if (first) {
                    writer.write(attributeName);
                    first = false;
                } else {
                    writer.write("," + attributeName);
                }
            }
            writer.newLine();
            attributeNames = session.getAttributeNames();
            first = true;
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                Object attributeValue = session.getAttribute(attributeName);
                if (first) {
                    writer.write(String.valueOf(attributeValue));
                    first = false;
                } else {
                    writer.write("," + String.valueOf(attributeValue));
                }
            }
            writer.newLine();
            System.out.println("Success wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void saveCSV(HttpSession session, String userToken) {
//        String FILEPATH = "src/main/java/org/example/myspring/util/";
//        File directory = new File(FILEPATH);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//        File file = new File(directory.getAbsolutePath() + "/" + userToken + ".csv");
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file,!file.exists()))){
//            App app = new App();
//
//            app.setMail((String) session.getAttribute("mail"));
//            app.setBer((String) session.getAttribute("ber"));
//            app.setPho((String) session.getAttribute("pho"));
//            app.setKjnhjn((Character) session.getAttribute("kjnhjn"));
//            app.setSeikj((String) session.getAttribute("seikj"));
//            app.setSeikn((String) session.getAttribute("seikn"));
//            app.setSeien((String) session.getAttribute("seien"));
//            app.setMeikj((String) session.getAttribute("meikj"));
//            app.setMeikn((String) session.getAttribute("meikn"));
//            app.setMeien((String) session.getAttribute("meien"));
//            app.setSex((Character) session.getAttribute("sex"));
//            app.setJkysbt((String) session.getAttribute("jkysbt"));
//            app.setTel((String) session.getAttribute("tel"));
//            app.setPost((String) session.getAttribute("post"));
//            app.setKnc((String) session.getAttribute("knc"));
//            app.setJskj1((String) session.getAttribute("jskj1"));
//            app.setJskj2((String) session.getAttribute("jskj2"));
//            app.setJskn1((String) session.getAttribute("jskn1"));
//            app.setJskn2((String) session.getAttribute("jskn2"));
//            app.setSpgtorkbn((String) session.getAttribute("spgtorkbn"));
//            app.setSpgkbn((String) session.getAttribute("spgkbn"));
//            app.setCsgkbn((String) session.getAttribute("csgkbn"));
//            app.setTorkbn((String) session.getAttribute("torkbn"));
//            app.setDriverid((String) session.getAttribute("driverid"));
//            app.setKkhcd((String) session.getAttribute("kkhcd"));
//            app.setHgsumk((Character) session.getAttribute("hgsumk"));
//            app.setKzkmlflg((Character) session.getAttribute("kzkmlflg"));
//            app.setCammlflg((Character) session.getAttribute("cammlflg"));
//            app.setGyocd((String) session.getAttribute("gyocd"));
//            app.setKms((String) session.getAttribute("kms"));
//            app.setKmsdep((String) session.getAttribute("kmsdep"));
//            app.setKmstel((String) session.getAttribute("kmstel"));
//            app.setKmsjs1((String) session.getAttribute("kmsjs1"));
//            app.setKmsjs2((String) session.getAttribute("kmsjs2"));
//            app.setNshym((String) session.getAttribute("nshym"));
//            app.setNsg((String) session.getAttribute("nsg"));
//            app.setKzkseikj((String) session.getAttribute("kzkseikj"));
//            app.setKzkseikn((String) session.getAttribute("kzkseikn"));
//            app.setKzkseien((String) session.getAttribute("kzkseien"));
//            app.setKzksex((Character) session.getAttribute("kzksex"));
//            app.setKzkgyocd((String) session.getAttribute("kzkgyocd"));
//            app.setKzkkms((String) session.getAttribute("kzkkms"));
//            app.setKzkkmsdep((String) session.getAttribute("kzkkmsdep"));
//            app.setKzkkmstel((String) session.getAttribute("kzkkmstel"));
//            app.setKzkhhucd((Character) session.getAttribute("kzkhhucd"));
//
//            writer.write(String.valueOf(app));
//        } catch (IOException e){
//            e.printStackTrace();
//        }


    // 写入CSV文件

//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory.getAbsolutePath() + "/" + userToken +".csv"))) {
//            writer.write(csvContent.toString());
//            System.out.println("Success wrote");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void addCSV(String csvContent, String userToken ,String path) {
//        File directory = new File(path);
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory.getAbsolutePath() + "/" + userToken + ".csv",true))) {
//            writer.write(csvContent.toString());
//            System.out.println("Success added");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
