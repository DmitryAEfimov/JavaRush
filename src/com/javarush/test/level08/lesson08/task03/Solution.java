package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args) {
       Map<String, String> map = createMap();

       getCountTheSameFirstName((HashMap) map, "Дмитрий");
       getCountTheSameLastName((HashMap) map, "Ефимова1");
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> fioMap = new HashMap<>();
        fioMap.put("Ефимов1", "Дмитрий");
        fioMap.put("Ефимов2", "Станислав");
        fioMap.put("Ефимов3", "Вадим");
        fioMap.put("Ефимов4", "Алексей");
        fioMap.put("Борисов5", "Даниил");
        fioMap.put("Борисов6", "Анастасия");
        fioMap.put("Ефимова10", "СоФия");
        fioMap.put("Ефимова8", "Людмила");
        fioMap.put("Ефимова1", "Дмитрий");
        fioMap.put("Ефимов10", "Анастасия");

        return fioMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count=0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(name))
                count++;
        }

        System.out.println("FirstName " + name +": " + count);
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;
        for (String curLastName : map.keySet())
            if (curLastName.equals(lastName))
                count++;
        System.out.println("LastName " + lastName +": " + count);
        return count;
    }
}
