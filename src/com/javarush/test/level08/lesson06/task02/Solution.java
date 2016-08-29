package com.javarush.test.level08.lesson06.task02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list)
    {
        //System.out.print(list.getClass().getName() +": insert -> ");
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
          //  System.out.print(list.get(i) + " ");
        }
        //System.out.println();
    }

    public static void remove10000(List list)
    {
        //System.out.print(list.getClass().getName() +": remove -> ");
        for (int i = 0; i < list.size();) {
            /*int obj = (int)*/ list.remove(i);
            //System.out.print(obj + " ");
        }
        //System.out.println();
    }

    public static void get10000(List list)
    {
        //System.out.print(list.getClass().getName() +": get -> ");
        for (int i = 0; i < 10000; i++) {
            /*int obj = (int) */list.get(i);
            //System.out.print(obj + " ");
        }
        //System.out.println();
    }

    public static void set10000(List list) {
        //System.out.print(list.getClass().getName() +": set -> ");
        for (int i = 0; i < 10000; i++) {
            list.add(i, new Object());
          //  System.out.print(list.get(i) + " ");
        }
        //System.out.println();
    }
}
