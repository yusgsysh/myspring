package org.example.myspring.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NewGetCSV {
    public static Map<String, String> getCSV(String userToken, String path) {
        String csvFile = path + "/" +userToken + ".csv";
        Map<String, String> dataMap = new HashMap<>();

        try (CSVParser parser = new CSVParser(new FileReader(csvFile), CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
            for (CSVRecord record : parser) {
                // 第一列是键，第二列是值
                String key = record.get(0);
                String value = record.get(1);
                dataMap.put(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataMap;
    }
}
