package org.example.myspring.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CreateID {
    public static String createID(String famflg) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDate = currentDate.format(formatter);
        String famCode = null;
        if ("1".equals(famflg)) {
            famCode = "01";
        } else if ("0".equals(famflg)) {
            famCode = "00";
        } else {
            famCode = "null";
        }
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        return formattedDate + "00" + famCode + randomNumber;
    }
}
