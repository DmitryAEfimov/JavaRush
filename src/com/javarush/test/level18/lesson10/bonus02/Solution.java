package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    private static File inventory;
    private static BufferedReader reader;

    public static void main(String[] args) throws Exception {
        long id;
        String name;
        double cost;
        int quantity;

        if (args.length < 4)
            throw new IllegalArgumentException("Wrong number of arguments");

        if (!"-c".equals(args[0])) {
            System.out.println("Wrong key. Use -c for create");
            return;
        }

        initFile();

        id = getId();
        name = args[1];
        cost = Double.parseDouble(args[2]);
        quantity = Integer.parseInt(args[3]);

        writeItem(id, name, cost, quantity);
    }

    private static long getId() throws IOException {
        String itemString;
        long max = Long.MIN_VALUE;

        try {
            reader = new BufferedReader(new FileReader(inventory));
            while (reader.ready()) {
                itemString = reader.readLine();
                if (!itemString.isEmpty() && Long.parseLong(itemString.substring(0,8).trim()) > max)
                    max = Long.parseLong(itemString.substring(0,8).trim());
            }
        } finally {
            if (reader != null) reader.close();
        }

        if (max == Long.MIN_VALUE) {
            return 1L;
        } else {
            return max+1;
        }
    }

    private static void writeItem(long id, String item, double cost, int quantity) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(inventory, true));
        try {
            writer.write(String.format("%-8.8s%-30.30s%-8.8s%-4.4s\n", String.valueOf(id), item, String.valueOf(cost), String.valueOf(quantity)));
        } finally {
            if (writer != null) writer.close();
        }

    }

    private static void initFile() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inventory = new File(reader.readLine());
        } finally {
            if (reader != null) reader.close();
        }
    }
}
