package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static String file1;
    private static String file2;

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        initFiles();

        try {
            List<Byte> number = new LinkedList<>();

            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            byte value;
            while (fis.available() > 0) {
                while ((value = (byte) fis.read()) != 0x20 && value > 0) {
                    number.add(value);
                }

                if (number.size() > 0) {
                    fos.write((Math.round(convertByteArrayToDouble(number)) + " ").getBytes());
                    number.clear();
                }
            }
        } finally {
            if (fis != null) fis.close();
            if (fos != null) fos.close();
        }
    }

    private static double convertByteArrayToDouble(List<Byte> number) {
        Byte[] bytes = number.toArray(new Byte[number.size()]);
        char[] chars = new char[bytes.length];

        for (int i = 0; i < chars.length; i++) {
            short ch = (short) bytes[i];
            chars[i] = (char) ch;
        }

        return Double.parseDouble(new String(chars));
    }

    private static void initFiles() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            file1 = reader.readLine();
            file2 = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
