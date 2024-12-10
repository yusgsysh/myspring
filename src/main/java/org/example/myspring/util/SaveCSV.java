package org.example.myspring.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static org.example.myspring.util.GetCSV.getCSV;

public class SaveCSV {
    public static void saveCSV(String userToken, Map<String, String> hashMap, String path) {
        String csvFilePath = path + "/" + userToken + ".csv";
        hashMap.putAll(getCSV(userToken, path));
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFilePath), CSVFormat.DEFAULT)) {
            // 检查文件是否为空，如果是，则写入表头
            if (new java.io.File(csvFilePath).length() == 0) {
                printer.printRecord("Key", "Value");
            }
            // 写入数据
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                printer.printRecord(entry.getKey(), entry.getValue());
            }
            System.out.println("Success wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
