package com.javarush.test.level20.lesson04.task05;

import java.io.*;

/* Как сериализовать что-то свое?
Сделайте так, чтобы сериализация класса Object была возможной
*/
public class Solution {
    public static void main(java.lang.String[] args) throws IOException, ClassNotFoundException {
        File tmp = File.createTempFile("javaRush", null);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tmp));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(tmp));

        Object object = new Object();
        object.string1 = new String();
        object.string2 = new String();

        object.print();
        System.out.println("=============");
        Solution.serializeStatic(objectOutputStream);
        objectOutputStream.writeObject(object);

        objectOutputStream.close();

        Object loadedObject = new Object();
        loadedObject.string1 = new String();
        loadedObject.print();
        System.out.println("=============");

        Solution.deserializeStatic(objectInputStream);
        loadedObject = (Object) objectInputStream.readObject();

        objectInputStream.close();

        loadedObject.print();
    }

    static class Object implements Serializable {
        public String string1;
        public String string2;

        public void print() {
            if (string1 != null) string1.print();
            if (string2 != null) string2.print();
        }
    }

    public static int countStrings;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void serializeStatic(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(countStrings);
    }

    public static void deserializeStatic(ObjectInputStream objectInputStream) throws IOException {
        countStrings = objectInputStream.readInt();
    }
}
