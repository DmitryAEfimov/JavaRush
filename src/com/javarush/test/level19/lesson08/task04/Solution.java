package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        testString.printSomething();
        String test = byteArrayOutputStream.toString();
        String result = "";
        String[] array = test.split("\\s+");

        Integer first = Integer.parseInt(array[0]);
        String operand = array[1];
        Integer second = Integer.parseInt(array[2]);


        switch (operand) {
            case "+":
                result = String.valueOf(first + second); break;
            case "-":
                result = String.valueOf(first - second); break;
            case "*":
                result = String.valueOf(first * second); break;
        }
        System.setOut(consoleStream);

        System.out.println(test + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("398 - 16 = ");
        }
    }
}

