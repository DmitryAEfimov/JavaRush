package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    private static String fileName;
    private static String id;

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        id = args[0];

        initFile();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String str;
            while ((str = reader.readLine()) != null) {
                if (parseString(str)) {
                    System.out.println(str);
                    break;
                }
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    private static void initFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }

    private static boolean parseString(String str) {
        return str.startsWith(id + " ");
    }
}
