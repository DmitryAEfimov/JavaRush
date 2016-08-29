package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String[] wordArray = s.trim().split("\\s+");

        HashMap<String, String> toUpperMap = new HashMap<>(wordArray.length);

        for (String str : wordArray)
            toUpperMap.put(str, str.substring(0,1).toUpperCase()+str.substring(1));

        for (Map.Entry<String, String> entry : toUpperMap.entrySet())
            s = s.replaceAll(entry.getKey(), entry.getValue());

        System.out.println(s);
    }
}