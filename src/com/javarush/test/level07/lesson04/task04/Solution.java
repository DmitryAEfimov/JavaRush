package com.javarush.test.level07.lesson04.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] array = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(reader.readLine());

        //sort(array);
        move(array);
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }

    private static void move(int[] array) {
        int maxIndex = array.length-1;

        for (int i = 0; i < array.length/2; i++) {
            int tmp = array[i];
            array[i] = array[maxIndex-i];
            array[maxIndex-i] = tmp;
        }
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > array[index])
                    index = j;
            }

            if (index != i) {
                int tmp = array[i];
                array[i] = array[index];
                array[index] = tmp;
            }
        }
    }
}
