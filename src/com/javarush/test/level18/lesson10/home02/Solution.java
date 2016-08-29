package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    private static byte[] buffer = new byte[1024];
    private static long charCount;
    private static long whitespaceCount;

    public static void main(String[] args) throws IllegalArgumentException {

        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        String fileName = args[0];
        try {
            FileInputStream fis = new FileInputStream(fileName);

            while (fis.available() > 0) {
                int realRead = fis.read(buffer);
                countLetters(realRead);
            }
            fis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println((double) Math.round(((double) whitespaceCount)/charCount*100*100)/100);
    }

    private static void countLetters(int realRead) {
        for (int i = 0; i < realRead; i++) {
            if (buffer[i] == 0x20) whitespaceCount++;
            charCount++;
        }
    }

}
