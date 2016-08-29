package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] buffer = new char[1024];

        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        if (reader != null) reader.close();

        Pattern pattern = Pattern.compile("\\p{Punct}|\\p{Space}");
        Matcher matcher;
        while (fileReader.ready()) {
            int readCount = fileReader.read(buffer);
            matcher = pattern.matcher(new String(buffer, 0, readCount));

            fileWriter.write(matcher.replaceAll(""));
        }
        if (fileReader != null) fileReader.close();
        if (fileWriter != null) fileWriter.close();
    }
}
