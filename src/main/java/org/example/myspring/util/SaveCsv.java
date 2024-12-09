package org.example.myspring.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCsv {
    public static void saveCSV(String csvContent, String userToken ,String path,String htm) {
        // 写入CSV文件
        File directory = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory.getAbsolutePath() + "/" + userToken + htm +".csv"))) {
            writer.write(csvContent.toString());
            System.out.println("Success wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
