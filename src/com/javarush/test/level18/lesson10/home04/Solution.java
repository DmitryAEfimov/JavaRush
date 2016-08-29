package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    private static final int BUFFER_SIZE = 10;
    private static String fileName1;
    private static String fileName2;
    private static byte[] buffer = new byte[BUFFER_SIZE];

    public static void main(String[] args) throws IOException {
        long offset = 0;
        int copiedBytes;
        long seekPosition;

        initFiles();
        FileInputStream fis = null;
        RandomAccessFile raf = null;

        try {
            fis = new FileInputStream(fileName2);
            raf = new RandomAccessFile(fileName1, "rw");

            long fisSize = fis.available();
            long rafSize = raf.length();

            while ((seekPosition = getSeekPosition(rafSize, offset)) >= 0 && offset < rafSize) {
                raf.seek(seekPosition);
                copiedBytes = raf.read(buffer, 0, getLengthToCopy(rafSize, offset));

                raf.seek(seekPosition+fisSize);
                raf.write(buffer, 0, copiedBytes);
                offset += copiedBytes;
            }

            raf.seek(0);
            while (fis.available() > 0) {
                copiedBytes = fis.read(buffer);
                raf.write(buffer, 0, copiedBytes);
            }
        } finally {
            if (fis != null) fis.close();
            if (raf != null) raf.close();
        }
    }

    private static int getLengthToCopy(long rafSize, long offset) {
        return rafSize - offset > buffer.length ? buffer.length : (int) (rafSize - offset);
    }

    private static long getSeekPosition(long size, long offset) {
        return size - offset > buffer.length ? size - offset - buffer.length : 0;
    }

    private static void initFiles() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } finally {
            reader.close();
        }
    }
}
