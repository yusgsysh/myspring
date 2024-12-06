package org.example.myspring.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCsv {
    public static void saveCSV(String csvContent, String userToken ,String path) {
        // 写入CSV文件
        File directory = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory.getAbsolutePath() + "/" + userToken + ".csv"))) {
            writer.write(csvContent.toString());
            System.out.println("Success wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
