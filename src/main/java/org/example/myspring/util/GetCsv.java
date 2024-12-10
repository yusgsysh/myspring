package org.example.myspring.util;

import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetCsv {

    public static void getCSV(HttpSession session, String userToken) {
        String FILEPATH = "src/main/java/org/example/myspring/util/";
        File directory = new File(FILEPATH);
        File file = new File(directory.getAbsolutePath() + "/" + userToken + ".csv");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String headerLine = br.readLine(); // 读取CSV文件的头部
                if (headerLine == null) {
                    System.out.println("CSV file is empty.");
                    return;
                }
                String[] headers = headerLine.split(",");

                String dataLine = br.readLine();
                if (dataLine == null) {
                    System.out.println("No data found in CSV file.");
                    return;
                }

                String[] values = dataLine.split(",");

                if (headers.length != values.length) {
                    System.out.println("Mismatch between headers and values in CSV file.");
                    return;
                }

                for (int i = 0; i < headers.length; i++) {
                    session.setAttribute(headers[i].trim(), values[i].trim());
                }
                System.out.println("Success read and set session attributes");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File does not exist.");
        }
    }




//    public static void getCSV(HttpSession session, String userToken ){
//        String FILEPATH = "src/main/java/org/example/myspring/util/";
//        File directory = new File(FILEPATH);
//        File file = new File(directory.getAbsolutePath() + "/" + userToken + ".csv");
//        if (file.exists()){
//            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//                System.out.println(br);

//                String line;
//                while ((line = br.readLine()) != null) {
//                    String[] parts = line.split(",");
//                    if (parts.length == 2) {
//                        session.setAttribute(parts[0].trim(), parts[1].trim());
//                    }
//                }

//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            return;
//        }

//    }
}
