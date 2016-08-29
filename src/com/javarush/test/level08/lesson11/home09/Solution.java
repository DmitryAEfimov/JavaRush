package com.javarush.test.level08.lesson11.home09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.concurrent.SynchronousQueue;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String date = reader.readLine();
            System.out.println(isDateOdd(date));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isDateOdd(String date) {
        Date curDate = new Date(date);
        curDate.setSeconds(0);
        curDate.setMinutes(0);
        curDate.setHours(0);

        Date newYear = new Date(curDate.getYear(),0,1,0,0,0);

        long dayDistance = (curDate.getTime() - newYear.getTime())/1000/86400;

        return dayDistance%2 == 0;
    }
}
