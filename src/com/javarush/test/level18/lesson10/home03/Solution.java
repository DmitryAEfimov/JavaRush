package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    private static final int BUFFER_SIZE = 10;
    private static String file1;
    private static String file2;
    private static String file3;

    private static byte[] buffer = new byte[BUFFER_SIZE];

    private static void initFiles() throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        FileOutputStream fos = null;

        try {
            initFiles();
            fos = new FileOutputStream(file1);

            fis1 = new FileInputStream(file2);
            fis2 = new FileInputStream(file3);

            while (fis1.available() > 0) {
                int realRead = fis1.read(buffer);
                fos.write(buffer, 0, realRead);
            }

            while (fis2.available() > 0) {
                int realRead = fis2.read(buffer);
                fos.write(buffer, 0, realRead);
            }

        } finally {
            if (fos != null) fos.close();
            if (fis1 != null) fis1.close();
            if (fis2 != null) fis2.close();
        }
    }
}
