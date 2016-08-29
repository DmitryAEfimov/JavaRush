package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    private static String inFile;
    private static String outFile;

    public static void main(String[] args) {
        try {
            initFiles();
            printDigits();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDigits() throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inFile));
            writer = new BufferedWriter(new FileWriter(outFile));

            while (reader.ready()) {
                writer.write(parseString(reader.readLine()));
            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }

    private static String parseString(String string) {
        String[] strings = string.split("\\s");
        StringBuilder sb = new StringBuilder();

        for (String str : strings) {
            try {
                Integer.parseInt(str);
                sb.append(str + " ");
            } catch (NumberFormatException e) {
            }
        }
        return sb.toString();
    }

    private static void initFiles() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            inFile = reader.readLine();
            outFile = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
