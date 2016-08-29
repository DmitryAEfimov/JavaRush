package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Set<Human> family = new HashSet<>();

        Human daugther = new Human("Соня", false, 10);
        family.add(daugther);
        Human son = new Human("Стас", true, 4);
        family.add(son);
        Human cat = new Human("Бончик", true, 8);
        family.add(cat);

        Human father = new Human("Дима", true, 35, daugther, son, cat);
        family.add(father);
        Human mother = new Human("Нaстя", false, 34, daugther, son, cat);
        family.add(mother);

        Human grandFather1 = new Human("Саша", true, 66, father);
        family.add(grandFather1);
        Human grandMother1 = new Human("Люда", false, 58, father);
        family.add(grandMother1);
        Human grandFather2 = new Human("Игорь", true, 57, mother);
        family.add(grandFather2);
        Human grandMother2 = new Human("Нина", false, 56, mother);
        family.add(grandMother2);

        for (Human man : family)
            System.out.println(man);
    }

    public static class Human
    {
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, Human ... children) {
            this.name = name;
            this.sex  = sex;
            this.age = age;

            if (children.length > 0) {
                this.children.addAll(Arrays.asList(children));
            }
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
