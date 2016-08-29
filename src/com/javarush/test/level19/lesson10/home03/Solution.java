package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, IllegalArgumentException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        readFile(args[0]);
    }

    private static void readFile(String inFile) throws IOException {
        BufferedReader reader = null;
        String personString;
        Calendar cld = Calendar.getInstance();

        try {
            reader = new BufferedReader(new FileReader(inFile));

            while ((personString = reader.readLine()) != null) {
                String[] personAttrs = personString.split("\\s+");
                int year = Integer.parseInt(personAttrs[personAttrs.length - 1].trim());
                int month = Integer.parseInt(personAttrs[personAttrs.length - 2].trim());
                int day = Integer.parseInt(personAttrs[personAttrs.length - 3].trim());
                cld.set(year, month-1, day, 0, 0, 0);

                String fio = "";
                for (int i = 0; i < personAttrs.length - 3; i++) {
                    fio += personAttrs[i] + " ";
                }
                PEOPLE.add(new Person(fio.trim(), cld.getTime()));
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

}
