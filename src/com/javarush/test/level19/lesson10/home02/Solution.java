package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private HashMap<String, Double> salaryMap = new HashMap<>();
    private ArrayList<String> richestEmployees = new ArrayList<>();

    public static void main(String[] args) throws IOException, IllegalArgumentException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        Solution application = new Solution();
        application.readSalary(args[0]);
        application.showRichestEmployees();
    }

    private void readSalary(String inFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        String employee;
        try {
            while ((employee = reader.readLine()) != null) {
                storeSalary(employee.split("\\s+"));
            }
        } finally {
            if (reader != null) reader.close();
        }
    }

    private void storeSalary(String[] employee) {
        String lastName = employee[0];

        if (!salaryMap.containsKey(lastName)) {
            salaryMap.put(lastName, 0d);
        }

        double salary = salaryMap.get(lastName) + Double.parseDouble(employee[1]);
        salaryMap.put(lastName, salary);
    }

    double salary = Double.MIN_VALUE;

    private void  defineRichestEmployees() {
        for (Map.Entry<String, Double> entry : salaryMap.entrySet()) {
            if (entry.getValue() == salary) {
                richestEmployees.add(entry.getKey());
            } else if (entry.getValue() > salary) {
                richestEmployees.clear();
                richestEmployees.add(entry.getKey());
                salary = entry.getValue();
            }
        }
    }

    private void showRichestEmployees() {
        defineRichestEmployees();

        for (String str : richestEmployees) {
            System.out.println(str);
        }
    }
}
