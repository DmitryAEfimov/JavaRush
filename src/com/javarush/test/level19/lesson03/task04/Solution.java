package com.javarush.test.level19.lesson03.task04;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException {
            Calendar cld = Calendar.getInstance();

            String[] personData = scanner.nextLine().split(" ");
            String lastName = personData[0];
            String firstName = personData[1];
            String middleName = personData[2];
            cld.set(Integer.parseInt(personData[5]), Integer.parseInt(personData[4])-1, Integer.parseInt(personData[3]), 0, 0, 0);

            return new Person(firstName, middleName, lastName, cld.getTime());
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
