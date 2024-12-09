package org.example.myspring.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class NewSaveCsv {
    public static void newSaveCsv(Map<String, String> hashMap, String csvFilePath) {
        hashMap.put("Name", "Alice");
        hashMap.put("Age", "30");
        hashMap.put("City", "New York");
        try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFilePath), CSVFormat.DEFAULT)) {
            // 检查文件是否为空，如果是，则写入表头
            if (new java.io.File(csvFilePath).length() == 0) {
                printer.printRecord(hashMap.keySet());
            }

            // 写入数据
            printer.printRecord(hashMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
