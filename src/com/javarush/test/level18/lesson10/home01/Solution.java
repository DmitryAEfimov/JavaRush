package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    private long letterCount;

    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        Solution application = new Solution();
        FileInputStream fis = null;

        if (args.length > 0) {
            try {
                fis = new FileInputStream(args[0]);
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }

        try {
            while (fis.available() > 0) {
                fis.read(buffer);
                application.letterCount += application.countEngLetters(buffer);
            }
            System.out.println(application.letterCount);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int countEngLetters(byte[] buffer) {
        int letterCount = 0;
        for (byte letter : buffer) {
            if (letter > 0x40 && letter < 0x7b ) letterCount++;
        }

        return letterCount;
    }
}
