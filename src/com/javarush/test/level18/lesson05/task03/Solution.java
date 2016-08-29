package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    private static String fileOrig;
    private static String fileFirst;
    private static String fileSecond;

    private static void initFiles() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            fileOrig = reader.readLine();
            fileFirst = reader.readLine();
            fileSecond = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        byte[] buffer = new byte[10];

        initFiles();
        try {
            FileInputStream fis = new FileInputStream(fileOrig);
            FileOutputStream fos = new FileOutputStream(fileFirst);

            int offset = 0, length;
            long halfFile;

            if (fis.available()%2 == 0) {
                halfFile = fis.available()/2;
            } else {
                halfFile = fis.available()/2 + 1;
            }

            while  (halfFile - offset > 0) {
                length = calcBytes(buffer, halfFile - offset);
                int realRead = fis.read(buffer, 0, length);
                offset += length;

                fos.write(buffer, 0, realRead);
            }

            fos.close();
            fos = new FileOutputStream(fileSecond);

            while (fis.available() > 0) {
                int realRead = fis.read(buffer);
                fos.write(buffer, 0, realRead);
            }
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calcBytes(byte[] buffer, long bytesLeft) {
        return bytesLeft > buffer.length ? buffer.length : (int) bytesLeft;
    }
}
