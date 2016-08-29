package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //map of addresses
        Map<String, String> addresses = new HashMap<>();

        //initialize map
        while (true)
        {
            String city = reader.readLine();
            if (city.isEmpty()) break;

            String family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.put(city, family);
        }

        //input city
        String checkCity = reader.readLine();
        if (addresses.size() > 0 && addresses.containsKey(checkCity))
        {
            System.out.println(addresses.get(checkCity));
        }
    }
}
