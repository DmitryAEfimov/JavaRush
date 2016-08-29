package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE;

        //напишите тут ваш код
        //System.out.print("Введите кол-во чисел для сравнения: ");
        int numberCnt = Integer.parseInt(reader.readLine());

        /*String spelling;
        switch(numberCnt) {
            case 1: spelling="число"; break;
            case 2:
            case 3:
            case 4: spelling="числа"; break;
            default: spelling="чисел";
        }

        System.out.println("Введите " + numberCnt + " " + spelling +": ");*/

        for (int i=0;i<numberCnt;i++) {
            int a = Integer.parseInt(reader.readLine());
            maximum = max(maximum, a);
        }

        System.out.println(maximum);
    }

    private static int max(int a, int b) {
        return a>b ? a:b;
    }
}
