package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();
    private List<String> origStrings = new ArrayList<>();
    private List<String> newStrings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Solution application = new Solution();
        application.initFilesAndFillArrays();
        application.findDifference();
    }

    private void findDifference() throws IOException {
        final int MAX_DIFF = 2; //max index difference
        int origIndex = 0, newIndex = 0, shift = 0; //first accordance to second
        int size = origStrings.size() > newStrings.size() ? origStrings.size() : newStrings.size();

        String origString;
        String newString;

        while (lines.size() < size + shift) {
            if (origIndex < origStrings.size()) {
                origString = origStrings.get(origIndex);
            } else {
                origString = origStrings.get(origStrings.size() - 1);
            }

            if (newIndex < newStrings.size()) {
                newString = newStrings.get(newIndex);
            } else {
                newString = newStrings.get(newStrings.size() - 1);
            }

            if (newIndex == (origIndex - shift) && origString.equals(newString)) {
                lines.add(new LineItem(Type.SAME, origString));
                origIndex++;
                newIndex++;
                continue;
            }

            if (newIndex - (origIndex - shift) < (MAX_DIFF - 1) && !origString.equals(newString)) {
                newIndex++;
                continue;
            }

            if ((newIndex - (origIndex - shift) < MAX_DIFF && origString.equals(newString)) ||
                    origIndex == origStrings.size() && newIndex <= newStrings.size()) {
                lines.add(new LineItem(Type.ADDED, newStrings.get(newIndex-(MAX_DIFF - 1))));
                shift--;
                size++;
            } else {
                lines.add(new LineItem(Type.REMOVED, origString));
                origIndex++;
                newIndex--;
                if (newIndex < newStrings.size()) {
                    shift++;
                } else {
                    shift--;
                }
            }
        }
    }

    private void initFilesAndFillArrays() throws IOException {
        BufferedReader consoleReader = null;
        BufferedReader origFileReader = null;
        BufferedReader newFileReader = null;

        try {
            consoleReader = new BufferedReader(new InputStreamReader(System.in));
            origFileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            newFileReader = new BufferedReader(new FileReader(consoleReader.readLine()));

            while (origFileReader.ready()) origStrings.add(origFileReader.readLine());
            while (newFileReader.ready())  newStrings.add(newFileReader.readLine());
        } finally {
            if (consoleReader != null) consoleReader.close();
            if (origFileReader != null) origFileReader.close();
            if (newFileReader != null) newFileReader.close();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString() + " " + line;
        }
    }
}
