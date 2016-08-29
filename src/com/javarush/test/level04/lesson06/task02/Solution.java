package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max=Integer.MIN_VALUE;
        for (int i=0;i<4;i++) {
            int curInt = Integer.parseInt(br.readLine());
            if (curInt > max)
                max = curInt;
        }
        System.out.println(max);
    }
}
