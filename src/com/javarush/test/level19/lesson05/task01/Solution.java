package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    private static String inFile;
    private static String outFile;

    public static void main(String[] args) throws IOException {
        initFiles();
        processFiles();
    }

    private static void processFiles() throws IOException {
        char[] buffer = new char[1024];
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        FileWriter writer = new FileWriter(outFile);

        try {
            while (reader.ready()) {
                int readCount = reader.read(buffer);
                for (int i = 1; i < readCount; i += 2)
                    writer.write(buffer[i]);
            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }

    private static void initFiles() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inFile = reader.readLine();
            outFile = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
