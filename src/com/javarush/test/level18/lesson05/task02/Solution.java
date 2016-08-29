package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) {
        String fileName;
        byte[] buffer = new byte[1024];
        int commaCount = 0;
        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();

            fis = new FileInputStream(fileName);
            while (fis.available() > 0) {
                int readCount = fis.read(buffer);
                for (int i = 0; i < readCount; i++) {
                    if (buffer[i] == 0x2c) commaCount++;
                }
            }
            fis.close();
            reader.close();

            System.out.println(commaCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
