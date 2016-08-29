package com.javarush.test.level18.lesson03.task02;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static String fileName;

    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        byte min = Byte.MAX_VALUE, b;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            while ((b = (byte) fis.read()) > 0) {
                if (b < min) {
                    min = b;
                }
            }
            System.out.println(min);
        }
    }
}
