package com.javarush.test.level08.lesson08.task04;

import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args) {
        HashMap dobMap = createMap();
        removeAllSummerPeople(dobMap);
    }
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Willis", new Date("DECEMBER 21 2005"));
        map.put("Pitt", new Date("NOVEMBER 11 1964"));
        map.put("Malkovich", new Date("JUNE 30 1956"));
        map.put("Efimov", new Date("FEBRUARY 24 1981"));
        map.put("Bukin", new Date("JANUARY 1 2012"));
        map.put("Borisov", new Date("JULY 21 1983"));
        map.put("Efimova", new Date("APRIL 21 1982"));
        map.put("Borisova", new Date("SEPTEMBER 17 1980"));
        map.put("Tcepinov", new Date("AUGUST 21 2000"));

        System.out.println("After init: ");
        for (Map.Entry<String, Date> entry : map.entrySet())
            System.out.print(entry.getKey()+"("+ entry.getValue()+"), ");
        System.out.println();

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        List<String> fioList = new ArrayList<>();

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Date> dobEntry = iterator.next();

            int month = dobEntry.getValue().getMonth();
            if (month >= 5 && month <= 7)
                fioList.add(dobEntry.getKey());
        }

        for (int i=0;i<fioList.size();i++) {
            map.remove(fioList.get(i));
        }
        System.out.print("After removing: ");
        for (Map.Entry<String, Date> entry : map.entrySet())
            System.out.print(entry.getKey()+"("+ entry.getValue()+"), ");
        System.out.println();
    }
}
