package com.javarush.test.level04.lesson07.task02;

/* Строка - описание
Ввести с клавиатуры целое число в диапазоне 1 - 999. Вывести его строку-описание следующего вида:
«четное однозначное число» - если число четное и имеет одну цифру,
«нечетное однозначное число» - если число нечетное и имеет одну цифру,
«четное двузначное число» - если число четное и имеет две цифры,
«нечетное двузначное число» - если число нечетное и имеет две цифры,
«четное трехзначное число» - если число четное и имеет три цифры,
«нечетное трехзначное число» - если число нечетное и имеет три цифры.
Если введенное число не попадает в диапазон 1 - 999, в таком случае ничего не выводить на экран.
Пример для числа 100:
четное трехзначное число
Пример для числа 51:
нечетное двузначное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        int intValue = Integer.parseInt(value);
        String len = "";

        if ((intValue > 0 && intValue < 1000)) {

            if (value.length() == 1)
                len = " однозначное число";
            if (value.length() == 2)
                len = " двузначное число";
            if (value.length() == 3)
                len = " трехзначное число";

            if (intValue % 2 == 0)
                len = "четное" + len;
            else
                len = "нечетное" + len;

            System.out.println(len);
        }
    }
}
