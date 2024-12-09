package org.example.myspring.util;

import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetCsv {
    public static void getCSV(HttpSession session,String userToken ,String path){
        File directory = new File(path);
        File file = new File(directory.getAbsolutePath() + "/" + userToken + ".csv");
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
