package com.javarush.test.level12.lesson09.task04;

/* Fly, Run, Swim для классов Human, Duck, Penguin, Airplane
Есть public интерфейсы Fly(летать), Run(бежать/ездить), Swim(плавать).
Добавь эти интерфейсы классам Human(человек), Duck(утка), Penguin(пингвин), Airplane(самолет).
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public interface Fly
    {
        void fly();
    }

    public interface Run
    {
        void run();
    }

    public interface Swim
    {
        void swim();
    }


    public class Human implements Run, Swim
    {

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements Run, Swim, Fly
    {

        @Override
        public void fly() {

        }

        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Penguin implements Run, Swim
    {

        @Override
        public void swim() {

        }

        @Override
        public void run() {

        }
    }

    public class Airplane implements Run, Fly
    {

        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }
    }
}
