package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Wrong number of arguments.");
        }

        Solution application = new Solution();
        application.processFiles(args[0], args[1]);
    }

    private void processFiles(String inFile, String outFile) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(inFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String string;
            String delimiter = "";

            while ((string = reader.readLine()) != null) {
                String[] array = string.split("\\s");
                for (String str : array) {
                    if (str.length() > 6) {
                        writer.write(delimiter + str);
                        delimiter=",";
                    }
                }

            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }
}
