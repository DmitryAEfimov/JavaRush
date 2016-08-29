package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        int[] lengthArray = {5, 2, 4, 7, 0};
        Random rnd = new Random();
        ArrayList<int[]> intList = new ArrayList<>();
        for (int i = 0; i < lengthArray.length; i++) {
            int[] tmpArray = new int[lengthArray[i]];
            for (int j = 0; j < tmpArray.length; j++) {
                tmpArray[j] = rnd.nextInt();
            }
            intList.add(tmpArray);
        }

        return intList;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
