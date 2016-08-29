package com.javarush.test.level18.lesson03.task01;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

import java.io.*;

public class Solution {
    static String fileName;
    static {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        byte max = 0, b;
        try (FileInputStream fis = new FileInputStream(fileName)) {
            while ((b = (byte) fis.read()) > 0) {
                if (b > max) {
                    max = b;
                }
            }
            System.out.println(max);
        }
    }
}
