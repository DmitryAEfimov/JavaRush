package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File tmp = File.createTempFile("javaRush", null);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tmp));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(tmp));

        Person person = new Person("Dmitry", "Efimov", "Russia", Sex.MALE);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        Person loadedPerson = (Person) objectInputStream.readObject();

        System.out.println(person.firstName);
        System.out.println(person.lastName);
        System.out.println(person.fullName);
        System.out.println(person.greetingString);
        System.out.println(person.country);
        System.out.println(person.sex.toString());
        System.out.println(person.outputStream);
        System.out.println(person.logger);
        System.out.println("===========");
        System.out.println(loadedPerson.firstName);
        System.out.println(loadedPerson.lastName);
        System.out.println(loadedPerson.fullName);
        System.out.println(loadedPerson.greetingString);
        System.out.println(loadedPerson.country);
        System.out.println(loadedPerson.sex.toString());
        System.out.println(loadedPerson.outputStream);
        System.out.println(loadedPerson.logger);
    }

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }
}
