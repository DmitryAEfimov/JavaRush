package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<>();
    private String inFile;

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        Solution application = new Solution();
        application.initFile();
        application.readFile();

    }

    private void initFile() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
           inFile = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }

    private void readFile() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inFile));
            String string;
            while ((string = reader.readLine()) != null) {
                if (isWordsMatch(string)) {
                    System.out.println(string);
                }
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    private boolean isWordsMatch(String string) {
        String[] array = string.split("\\p{Punct}+|\\p{Space}+");
        int match = 0;
        for (String checkedWord : array) {
            if (Collections.frequency(words, checkedWord) > 0) match++;
            if (match > 2) return false;
        }

        return match == 2;
    }
}
