package com.javarush.test.level05.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);

        //напишите тут ваш код
        Mouse babyMouse = new Mouse("Pip", 4, 1);

        Dog daddyDog = new Dog("Daddy", 10, 100);
        Dog babyDog = new Dog("Child", 1, 3);
        Dog someDog = new Dog("Never exist", 10000, 123);

        Cat tomCat = new Cat("Tom", "Male", "Grey");
        Cat girlCat = new Cat("Don't remember", "Female", "White");
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }

    //добавьте тут ваши классы
    public static class Dog {
        String name;
        int age;
        int weight;

        public Dog(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }

    public static class Cat {
        String name;
        String gender;
        String color;

        public Cat(String name, String gender, String color) {
            this.name = name;
            this.gender = gender;
            this.color = color;
        }
    }


}
