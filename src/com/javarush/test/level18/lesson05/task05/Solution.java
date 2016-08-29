package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static Set<FileInputStream> streamSet = new HashSet<>();

    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while (true) {
            try {
                fileName = reader.readLine();
                FileInputStream fis = new FileInputStream(fileName);
                streamSet.add(fis);
                if (fis.available() < 1000) {
                    closeStreams();
                    reader.close();
                    throw new DownloadException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void closeStreams() {
        for (FileInputStream fis : streamSet) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DownloadException extends Exception{

    }
}
