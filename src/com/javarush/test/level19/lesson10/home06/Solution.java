package com.javarush.test.level19.lesson10.home06;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();
    private static String inFile;

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        initFile();
        read();
    }

    private static void read() throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(inFile));

            String regexp = "(?<=\\s|^)([1-9][0-9]*)(?=\\s|$)";
            Matcher matcher = Pattern.compile(regexp).matcher("");

            while (reader.ready()) {
                matcher.reset(reader.readLine());
                StringBuffer sb = new StringBuffer();
                int key;

                while (matcher.find()) {
                    if (map.containsKey((key = Integer.parseInt(matcher.group(1))))) {
                        matcher.appendReplacement(sb, map.get(key));
                    }
                }
                System.out.println(matcher.appendTail(sb).toString());
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    private static void initFile() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            inFile = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
