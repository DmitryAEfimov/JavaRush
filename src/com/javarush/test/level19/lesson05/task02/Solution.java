package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private  String inFile;

    public static void main(String[] args) throws IOException {
        Solution application = new Solution();
        application.initFile();
        application.countWords();
    }

    private void countWords() throws IOException {
        long words = 0;

        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        PrintStream printStream = new PrintStream(System.out);
        Pattern pattern = Pattern.compile("(?<=\\p{Punct}|\\p{Space}?)world(?=\\p{Punct}|\\p{Space})", Pattern.CASE_INSENSITIVE);

        try {
            String bufferStr;
            while (reader.ready()) {
                bufferStr = reader.readLine();
                Matcher matcher = pattern.matcher(bufferStr);
                while (matcher.find()) {
                    words++;
                }
            }
            printStream.print(words);
        } finally {
            if (reader != null) reader.close();
            if (printStream != null) printStream.close();
        }
    }

    private void initFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inFile = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
