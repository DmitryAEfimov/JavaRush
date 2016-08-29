package com.javarush.test.level08.lesson08.task02;

import java.util.*;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main (String[] args) {
        Set<Integer> set = createSet();
        removeAllNumbersMoreThan10((HashSet) set);
    }

    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> intSet = new HashSet<>();
        Random rnd = new Random();

        while (intSet.size() < 20 )
            intSet.add(rnd.nextInt(40));

        System.out.print("After init: ");
        for (int value : intSet)
            System.out.print(value + " ");
        System.out.println();

        return intSet;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        Iterator<Integer> iterator = set.iterator();
        ArrayList<Integer> list = new ArrayList<>();

        while (iterator.hasNext()) {
            int value = iterator.next();

            if (value > 10)
                list.add(value);
        }

        set.removeAll(list);

        System.out.print("After remove: ");
        for (int value : set)
            System.out.print(value + " ");
        System.out.println();

        return set;
    }
}
