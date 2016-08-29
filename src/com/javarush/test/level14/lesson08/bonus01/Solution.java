package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] array = new int[2];
            System.out.println(array[3]);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Integer i = new Integer("xxx");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File f = null;
            f.canRead();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            File file = new File("c:\\xxx");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Class.forName("ru.defimov.Person");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
           int[] array = new int[-10];
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            String str = "sdsvjkdfjb";
            str.substring(100);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Method method = Class.forName("com.javarush.test.level14.lesson08.bonus01.Solution$Person").getMethod("getName");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Map<String, Number> numberMap = new HashMap<>();
            numberMap.put("key", (int) 10);
            double d = (Double) numberMap.get("key");
        } catch (Exception e) {
            exceptions.add(e);
        }
    }

    static class Person {

    }
}
