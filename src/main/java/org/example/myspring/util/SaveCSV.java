package org.example.myspring.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.myspring.util.GetCSV.getCSV;

public class SaveCSV {

    private static final ConcurrentHashMap<String, Object> FILE_LOCKS = new ConcurrentHashMap<>();

    public static void saveCSV(String userToken, Map<String, String> hashMap, String path) {
        String csvFilePath = path + "/" + userToken + ".csv";
        Object lock = FILE_LOCKS.computeIfAbsent(csvFilePath, k -> new Object());
        synchronized (lock) {
            Map<String, String> inputMap = getCSV(userToken, path);
            inputMap.putAll(hashMap);
            try (CSVPrinter printer = new CSVPrinter(new FileWriter(csvFilePath), CSVFormat.DEFAULT)) {
                printer.printRecord("Key", "Value");
                for (Map.Entry<String, String> entry : inputMap.entrySet()) {
                    printer.printRecord(entry.getKey(), entry.getValue());
                }
                System.out.println("Success wrote to " + userToken + ".csv");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
