package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int one = Integer.parseInt(br.readLine());
        int two = Integer.parseInt(br.readLine());
        int three = Integer.parseInt(br.readLine());

        if (one < two && one < three)
            if (two >= three)
                System.out.println(three);
            else
                System.out.println(two);

        if (one >= two && one >= three)
            if (two >= three)
                System.out.println(two);
            else
                System.out.println(three);

        if (one >= two && one < three || one < two && one >= three)
            System.out.println(one);
    }
}
