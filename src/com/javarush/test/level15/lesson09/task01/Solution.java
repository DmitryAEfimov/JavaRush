package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1d, "1");
        labels.put(2.5, "2.5");
        labels.put(0.333, "0.333");
        labels.put((double) 100, "(double) 100");
        labels.put(0.0, "0.0");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
