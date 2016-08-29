package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        System.out.println("After init: ");
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.print(entry.getKey()+"("+ entry.getValue()+"), ");
        System.out.println();


        removeTheFirstNameDuplicates(map);
        System.out.println("After remove: ");
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.print(entry.getKey()+"("+ entry.getValue()+"), ");
        System.out.println();
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> fioMap = new HashMap<>();
        fioMap.put("Ефимов1", "Дмитрий");
        fioMap.put("Ефимов2", "Станислав");
        fioMap.put("Ефимов3", "Станислав");
        fioMap.put("Ефимов4", "Алексей");
        fioMap.put("Борисов5", "Даниил");
        fioMap.put("Борисов6", "Анастасия");
        fioMap.put("Ефимова10", "СоФия");
        fioMap.put("Ефимова8", "Людмила");
        fioMap.put("Ефимова1", "Дмитрий");
        fioMap.put("Ефимов10", "Анастасия");

        return fioMap;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, Integer> fioCntMap = new HashMap<>();
        for (Map.Entry<String,String> entry : map.entrySet()) {
            String name = entry.getValue();
            if (fioCntMap.containsKey(name)) {
                int nameCnt = fioCntMap.get(name);
                fioCntMap.put(name, ++nameCnt);
            } else
                fioCntMap.put(name, 1);
        }

        for (Map.Entry<String, Integer> entry : fioCntMap.entrySet()) {
            if (entry.getValue() > 1)
                removeItemFromMapByValue(map, entry.getKey());
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
