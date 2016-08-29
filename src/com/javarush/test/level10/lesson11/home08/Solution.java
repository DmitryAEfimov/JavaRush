package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.Random;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String>[] arrayList = new ArrayList[10];

        for (int i = 0; i < arrayList.length; i++) {
            ArrayList<String> array = new ArrayList<>();
            Random rnd = new Random();

            int randomInt = rnd.nextInt(9);
            System.out.println("i = " + i + ": " + randomInt);
            for (int j = 0; j < randomInt; j++) {
                String str = String.valueOf(rnd.nextInt(34323));
                array.add(str);
            }

            arrayList[i] = array;
        }
        return arrayList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}