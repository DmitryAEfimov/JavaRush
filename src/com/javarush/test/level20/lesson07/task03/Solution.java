package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File tmp = File.createTempFile("javaRush", null);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(tmp));
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(tmp));

        Person me = new Person("Дмитрий", "Ефимов", 35);
        Person father = new Person("Александр", "Ефимов", 66);
        Person mother = new Person("Людмила", "Ефимова", 58);
        Person daughter = new Person("София", "Ефимова", 10);
        Person son = new Person("Станислав", "Ефимов", 4);

        me.setFather(father);
        me.setMother(mother);

        List<Person> children = new ArrayList<>(2);

        children.add(son);
        children.add(daughter);
        me.setChildren(children);

        me.writeExternal(objectOutputStream);
        objectOutputStream.close();

        Person loadedMe = new Person();

        loadedMe.readExternal(objectInputStream);
        objectInputStream.close();

        System.out.println(loadedMe.toString());
    }

    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List) in.readObject();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(firstName + " " + lastName + ", " + age + "\n");
            if (mother != null)
                sb.append("mother: " + mother.toString());
            if (father != null)
                sb.append("father: " + father.toString());
            if (children != null && children.size() > 0) {
                for (Person child : children) {
                    sb.append(child.toString());
                }
            }
            return sb.toString();
        }
    }
}
