package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        List<String> list;
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;

        try {
            str = reader.readLine();

            list = Arrays.asList(str.substring(str.indexOf('?')+1).split("&"));
            List<String> keysList = new ArrayList<>(list.size());
            List<String> valuesList = new ArrayList<>(list.size());

            for (String keyValuePair : list) {
               if (keyValuePair.contains("=")) {
                   keysList.add(keyValuePair.substring(0, keyValuePair.indexOf("=")));
                   valuesList.add(keyValuePair.substring(keyValuePair.indexOf("=")+1));
               } else {
                   keysList.add(keyValuePair);
                   valuesList.add(null);
               }
            }

            StringBuilder sb = new StringBuilder();
            String value = null;

            String separator = "";
            for (int i = 0; i< keysList.size(); i++) {
                sb.append(separator + keysList.get(i));
                separator = " ";
                if ("obj".equals(keysList.get(i))) {
                    value = valuesList.get(i);
                }
            }

            System.out.println(sb.toString());

            if (value != null && !value.isEmpty()) {
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
