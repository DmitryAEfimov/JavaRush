package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int one, two, three;
        int min = Integer.MIN_VALUE, mid = min, max = min;

        one = Integer.parseInt(br.readLine());
        two = Integer.parseInt(br.readLine());
        three = Integer.parseInt(br.readLine());

        if (one >= two && one >= three) {
            max = one;
            if (two >= three) {
                mid = two;
                min = three;
            } else {
                mid = three;
                min = two;
            }
        }

        if (two >= one && two >= three) {
            max = two;
            if (one >= three) {
                mid = one;
                min = three;
            } else {
                mid = three;
                min = one;
            }
        }

        if (three >= one && three >= two) {
            max = three;
            if (one >= two) {
                mid = one;
                min = two;
            } else {
                mid = two;
                min = one;
            }
        }

        System.out.println(max);
        System.out.println(mid);
        System.out.println(min);
    }
}
