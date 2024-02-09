package ru.spbstu.telematics.java;

public class Main {
    public static void main(String[] args) {
        MyUUID uuidGenerator = new MyUUID();
        String uuid = uuidGenerator.generateUUID();
        System.out.println("Custom UUID: " + uuid);

        MyUUID uuidGenerator2 = new MyUUID();
        String uuid2 = uuidGenerator2.generateUUID();
        System.out.println("Custom UUID2: " + uuid2);
    }
}
