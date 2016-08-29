package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int first, second;

        try {
            first = Integer.parseInt(reader.readLine());
            second = Integer.parseInt(reader.readLine());

            System.out.println(findNOD(first, second));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findNOD(int first, int second) {
        if (first%second> 0) {
            first %= second;
            second = findNOD(second, first);
        }
        return second;
    }
}
