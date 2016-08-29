package com.javarush.test.level04.lesson04.task01;

/* Меньше 5 - и
Реализовать метод compare(int a). Метод должен выводить строку на экран "Число меньше 5", если параметр метода меньше 5 - и,
выводить строку "Число больше 5", если параметр метода больше 5 - и,
и выводить строку "Число равно 5", если параметр метода равен 5 - и.
*/

public class Solution
{
    public static void main(String[] args)
    {
        compare(3);
        compare(6);
        compare(5);
    }

    public static void compare(int a)
    {
        final int etalon = 5;
        String compareResult = "";
        //напишите тут ваш код
        if (a < etalon)
            compareResult = "меньше";
        if (a > etalon)
            compareResult = "больше";
        if (a == etalon)
            compareResult = "равно";

        System.out.println("Число " + compareResult + " " + etalon);

    }
}