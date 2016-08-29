package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private TreeMap<String, Double> salaryMap = new TreeMap<>();

    public static void main(String[] args) throws IOException, IllegalArgumentException {

        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        Solution application = new Solution();

        application.readSalary(args[0]);
        application.showSalaries();
    }

    private void showSalaries() {
        for (Map.Entry<String, Double> entry : salaryMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
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
}
