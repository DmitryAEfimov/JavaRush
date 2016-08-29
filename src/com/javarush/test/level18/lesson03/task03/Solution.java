package com.javarush.test.level18.lesson03.task03;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    static String fileName;
    static Map<Byte, Integer> byteMap = new HashMap<>();
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        byte b;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while ((b = (byte) fis.read()) > 0) {
                put(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        showFrequency();
    }

    private static void showFrequency() {
        int max = 0;
        for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > max) {
                max = frequency;
            }
        }

        String delimiter = "";
        for (Byte b : byteMap.keySet()) {
            if (byteMap.get(b) == max) {
                System.out.print(delimiter + b);
                delimiter = " ";
            }
        }
    }

    private static void put(byte b) {
        if (!byteMap.containsKey(b)) {
            byteMap.put(b, 0);
        }
        int value = byteMap.get(b);
        byteMap.put(b, ++value);
    }
}
