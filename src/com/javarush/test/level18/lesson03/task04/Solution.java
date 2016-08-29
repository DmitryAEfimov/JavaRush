package com.javarush.test.level18.lesson03.task04;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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
    private static String fileName;
    private static Map<Byte, Integer> byteMap = new HashMap<>();

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
        }

        showFrequency();
    }

    private static void showFrequency() {
        int min = Integer.MAX_VALUE, frequency;
        for (Map.Entry<Byte, Integer> entry : byteMap.entrySet()) {
            frequency = entry.getValue();

            if (min > frequency) {
                min = frequency;
            }
        }

        String delimiter = "";
        for (byte b : byteMap.keySet()) {
            if (byteMap.get(b) == min) {
                System.out.print(delimiter + b);
                delimiter = " ";
            }
        }
    }

    private static void put(byte b) {
        if (!byteMap.containsKey(b)) {
            byteMap.put(b, 0);
        }

        int frequency = byteMap.get(b);
        byteMap.put(b, ++frequency);
    }
}
