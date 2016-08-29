package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> letterLSet = new HashSet<>();
        letterLSet.add("Л");
        letterLSet.add("ЛЛ");
        letterLSet.add("ЛЛЛ");
        letterLSet.add("Лл");
        letterLSet.add("Ллл");
        letterLSet.add("ЛлЛ");
        letterLSet.add("ЛЛл");
        letterLSet.add("ЛОЛ");
        letterLSet.add("Лол");
        letterLSet.add("ЛоЛ");
        letterLSet.add("ЛОл");
        letterLSet.add("ЛИЛ");
        letterLSet.add("Лил");
        letterLSet.add("ЛИл");
        letterLSet.add("ЛиЛ");
        letterLSet.add("ЛЕС");
        letterLSet.add("Лес");
        letterLSet.add("ЛЕс");
        letterLSet.add("ЛеС");
        letterLSet.add("Лось");

        return letterLSet;
    }
}
