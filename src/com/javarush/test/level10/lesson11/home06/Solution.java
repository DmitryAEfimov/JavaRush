package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        String lastName;
        boolean sex;
        int age;
        boolean isMarried;
        Human spouse;

        //1
        public Human (boolean sex) {
            this.sex = sex;
        }

        //2
        public Human (boolean sex, String name) {
            this.sex = sex;
            this.name = name;

        }

        //3
        public Human (boolean sex, String name, String lastName) {
            this(sex, name);
            this.lastName = lastName;
        }

        //4
        public Human (boolean sex, String name, String lastName, int age) {
            this(sex, name, lastName);
            this.age = age;
        }

        //5
        public Human (boolean sex, String name, String lastName, int age, boolean isMarried) {
            this(sex, name, lastName, age);
            this.isMarried = isMarried;
        }

        //6
        public Human(boolean sex, String name, String lastName, int age, boolean isMarried, Human spouse) {
            this(sex, name, lastName, age, isMarried);
            this.spouse = spouse;
        }

        //7
        public Human(boolean sex, String name, String lastName, Human spouse) {
            this(sex, name, lastName);
            if (spouse != null) {
                this.isMarried = true;
                this.spouse = spouse;
            }
        }

        //8
        public Human(boolean sex, String name, int age) {
            this(sex, name);
            this.age = age;
        }

        //9

        public Human(boolean sex, int age) {
            this.sex = sex;
            this.age = age;
        }

        //10
        public Human () {} //default

    }
}
