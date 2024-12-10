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
            Enumeration<String> attributeNames = session.getAttributeNames();

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

}
