package com.javarush.test.level18.lesson03.task05;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());

        long[] arrBytes = new long[256];
        // Считываем массив
        while (inputStream.available() > 0) arrBytes[inputStream.read()]++;
        // Выводим отсортированный по байт-коду в обратном порядке
        for (int i = 0; i < arrBytes.length; i++)
            if (arrBytes[i] > 0) System.out.print(i + " ");

        inputStream.close();
    }
}
