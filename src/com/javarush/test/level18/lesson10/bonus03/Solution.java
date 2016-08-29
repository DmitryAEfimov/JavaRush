package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    private char action;
    private long id;
    private String name;
    private double price;
    private int quantity;

    private File inventory, tmpFile;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public static void main(String[] args) throws Exception {
        Solution application = new Solution();
        application.initFile();
        application.initAction(args);

        application.processFile();
        application.saveChanges();
    }

    private void saveChanges() throws IOException {
        Files.move(tmpFile.toPath(), inventory.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
    }

    private void initAction(String[] args) {
        switch (args[0].substring(1)) {
            case "d":
                if (!checkArgs(2, "id for delete", args)) {
                    return;
                }
                action = 'd';
                id = Long.parseLong(args[1]);
                break;
            case ("u"):
                if (!checkArgs(5, "id, productName, price, quantity for update", args)) {
                    return;
                }
                action = 'u';
                id = Long.parseLong(args[1]);
                name = args[2];
                price = Double.parseDouble(args[3]);
                quantity = Integer.parseInt(args[4]);
                break;
            default:
                System.out.println("Wrong key. Use u for update; d for delete");
        }
    }

    private void processFile() throws IOException {
        String itemString;

        try {
            reader = new BufferedReader(new FileReader(inventory));
            writer = new BufferedWriter(new FileWriter(tmpFile));

            while (reader.ready()) {
                itemString = reader.readLine();

                if (itemString.isEmpty() || Long.parseLong(itemString.substring(0,8).trim()) != id) {
                    writeFile(itemString);
                } else if (action == 'd') {
                    writeFile("");
                } else if (action == 'u') {
                    writeFile(String.format("%-8.8s%-30.30s%-8.8s%-4.4s", String.valueOf(id), name, String.valueOf(price), String.valueOf(quantity)));
                }
            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }

    private void writeFile(String str) throws IOException {
        writer.write(str +"\n");
    }

    private void initFile() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inventory = new File(reader.readLine());
            tmpFile = new File(inventory.getAbsolutePath()+".tmp");
        } finally {
            if (reader != null) reader.close();
        }
    }

    private boolean checkArgs(int number, String argList, String ... args) {
        if (args.length != number) {
            System.out.println("Wrong number of arguments. Use " + argList);
            return false;
        }
        return true;
    }
}
