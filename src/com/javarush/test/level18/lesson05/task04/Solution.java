package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    private static byte[] buffer = new byte[10];
    private String directFile;
    private String reverseFile;

    private void initFiles() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            directFile = reader.readLine();
            reverseFile = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Solution application = new Solution();

        application.initFiles();

        try {
            FileInputStream fis = new FileInputStream(application.directFile);
            RandomAccessFile raf = new RandomAccessFile(application.reverseFile, "rws");

            long fileSize = fis.available();
            long offset = 0;

            while (fis.available() > 0) {
                int readBytes = fis.read(buffer);
                makeReverse(readBytes);
                raf.seek(fileSize - offset - readBytes);
                raf.write(buffer, 0, readBytes);
                offset += readBytes;
            }

            raf.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeReverse(int readBytes) {
        int limit = readBytes/2;
        for (int i = 0; i < limit; i++) {
            byte tmp = buffer[i];
            buffer[i] = buffer[readBytes - 1 - i];
            buffer[readBytes - 1 - i] = tmp;
        }
    }
}
