package ru.spbstu.telematics.java;

import java.security.SecureRandom;
import java.time.Instant;

public class MyUUID {
    //SecureRandom - это класс в Java, предназначенный для 
    //генерации криптографически безопасных случайных чисел.
    private final SecureRandom random = new SecureRandom();

     public String generateUUID() {
        byte[] data = new byte[16];
        random.nextBytes(data);

        // Установим версию и вариант UUID
        data[6] &= 0x0f;  // Версия 4 (случайная)
        data[6] |= 0x40;
        data[8] &= 0x3f;  // Вариант 2 (RFC 4122)
        data[8] |= 0x80;

        // Преобразуем первые 8 байт в шестнадцатеричное представление времени
        Instant instant = Instant.now();
        long timestamp = instant.toEpochMilli();
        //System.out.println("currentTimeMillis: " + timestamp);
        for (int i = 4; i < 8; i++) {
            data[i-4] = (byte) ((timestamp >> (8 * (7 - i))) & 0xFF);
            //System.out.println("(byte) ((timestamp >> (8 * (7 - i))) & 0xFF): " + (byte) ((timestamp >> (8 * (7 - i))) & 0xFF));
        }
       // System.out.println("data: " + data);

        return formatUUID(data);
    }


    private String formatUUID(byte[] data) {
        StringBuilder builder = new StringBuilder(36);
        for (int i = 0; i < 16; i++) {
            if (i == 4 || i == 6 || i == 8 || i == 10) {
                builder.append("-");
            }
            builder.append(String.format("%02x", data[i]));
            //System.out.println("builder" +builder);
            //System.out.println("String.format(\"%02x\", data[i]) " +String.format("%02x", data[i]));
            //System.out.println("data[i " +data[i]);
        }
        //System.out.println("String.format(\"%02x\", data[7]) " +String.format("%02x", data[7]));
       // System.out.println("builder" +builder);
        return builder.toString();
    }

}
