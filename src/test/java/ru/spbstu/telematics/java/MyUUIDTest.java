package ru.spbstu.telematics.java;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;


public class MyUUIDTest {


    public MyUUIDTest() {
        
    }
    @Test
    public void testGenerateUUID() {
        MyUUID uuidGenerator = new MyUUID();
        Set<String> uuidSet = new HashSet<>();
        int numberOfUUIDsToGenerate = 1000; // Число сгенерированных UUID для теста
        for (int i = 0; i < numberOfUUIDsToGenerate; i++) {
            String uuid = uuidGenerator.generateUUID();
            assertNotNull(uuid);
            assertEquals(36, uuid.length()); // Убедимся, что UUID имеет правильную длину
            assertTrue(uuid.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")); // Убедимся, что UUID соответствует формату
            assertTrue(uuidSet.add(uuid)); // Попробуем добавить UUID в множество. Если добавление успешно, то UUID уникален.
        }
        assertEquals( numberOfUUIDsToGenerate, uuidSet.size()); // Убедимся, что количество уникальных UUID равно числу сгенерированных UUID.
    }

}
