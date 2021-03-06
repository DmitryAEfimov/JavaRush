package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A {
        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
        public A() {}
    }

    public class B extends A implements Serializable {
        private static final long serialVersionUID = 1L;

        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(name);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            name = (String) objectInputStream.readObject();
        }
    }
}
