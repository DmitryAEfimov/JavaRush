package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    private static TreeSet<String> fileNameSet = new TreeSet<>();
    private static File outFile;

    public static void main(String[] args) throws IOException {
        initStreams();
        mergeStreams();
    }

    private static void mergeStreams() throws IOException {
        FileInputStream fis;
        FileOutputStream fos = null;
        byte[] buffer = new byte[1024];

        try {
            fos = new FileOutputStream(outFile);
            for (String fileName : fileNameSet) {
                fis = new FileInputStream(fileName);

                int read = fis.read(buffer);
                fos.write(buffer, 0, read);
                fis.close();
            }
        } finally {
            if (fos != null) fos.close();
        }
    }

    private static void initStreams() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        try {
            while (true) {
                fileName = reader.readLine();
                if ("end".equals(fileName)) break;
                if (fileNameSet.size() == 0) setOutFile(fileName);

                fileNameSet.add(fileName);
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    public static void setOutFile(String fileName) {
        String outFileName = fileName.substring(0, fileName.lastIndexOf('.'));

        outFile = new File(outFileName);
    }
}
