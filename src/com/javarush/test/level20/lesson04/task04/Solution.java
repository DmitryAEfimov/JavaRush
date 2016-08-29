package com.javarush.test.level20.lesson04.task04;

import java.io.*;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File tmp = File.createTempFile("javaRush", null);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmp));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tmp));

        ClassWithStatic testClass = new ClassWithStatic();
        testClass.i = 5;
        testClass.j = 6;

        ClassWithStatic.serializeStatic(oos);
        oos.writeObject(testClass);
        oos.close();

        ClassWithStatic.staticString = "bla";

        ClassWithStatic.deserializeStatic(ois);
        ClassWithStatic loadedClass = (ClassWithStatic) ois.readObject();
        System.out.println(loadedClass.staticString + ", " + loadedClass.i +", " + loadedClass.j);

        ois.close();
    }

    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public static void serializeStatic(ObjectOutputStream outputStream) throws IOException {
            outputStream.writeBytes(staticString);
        }

        public static void deserializeStatic(ObjectInputStream inputStream) throws IOException {
            byte[] buffer = new byte[10];
            StringBuilder sb = new StringBuilder();

            while (inputStream.available() > 0) {
                int readCount = inputStream.read(buffer);
                sb.append(new String(buffer, 0, readCount));
            }
            staticString = sb.toString();
        }
    }
}
