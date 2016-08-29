package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private static TreeMap<Byte, Long> asciiFrequency = new TreeMap<>();

    public static void main(String[] args) throws IllegalArgumentException, IOException {
        FileInputStream fis = null;

        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        try {
            fis = new FileInputStream(args[0]);

            while (fis.available() > 0) {
                byte b = (byte) fis.read();

                if (!asciiFrequency.containsKey(b)) asciiFrequency.put(b, 0L);

                long value = asciiFrequency.get(b);
                asciiFrequency.put(b, ++value);
            }

            for (Map.Entry<Byte, Long> entry : asciiFrequency.entrySet()) {
                char ch = (char) entry.getKey().shortValue();
                System.out.println(new String() + " " + entry.getValue());
            }
        } finally {
            if (fis != null) fis.close();
        }

    }
}
