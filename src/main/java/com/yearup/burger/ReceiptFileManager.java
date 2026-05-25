package com.yearup.burger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    // Saves the receipt using date and time as file name
    public void saveReceipt(Order order) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = "src/main/resources/receipts/" + LocalDateTime.now().format(formatter) + ".txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            writer.write(order.getReceiptText());

            writer.close();

            System.out.println("Receipt saved successfully: " + fileName);

        } catch (Exception e) {
            System.out.println("Error saving receipt.");
        }
    }
}
