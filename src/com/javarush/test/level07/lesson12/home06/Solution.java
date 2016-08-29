package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human motherGrandFather = new Human("Игорь", true, 56);
        Human motherGrandMother = new Human("Нина", false, 55);

        Human fatherGrandFather = new Human("Саша", true, 65);
        Human fatherGrandMother = new Human("Люда", false, 58);

        Human father = new Human("Дима", true, 35, fatherGrandFather, fatherGrandMother);
        Human mother = new Human("Настя", false, 34, motherGrandFather, motherGrandMother);

        Human daughter = new Human("Соня", false, 10, father, mother);
        Human son = new Human("Стас", true, 4, father, mother);
        Human cat = new Human("Бончик", true, 7, father, mother);

        System.out.println(fatherGrandFather.toString());
        System.out.println(fatherGrandMother.toString());

        System.out.println(motherGrandFather.toString());
        System.out.println(motherGrandMother.toString());

        System.out.println(father.toString());
        System.out.println(mother.toString());

        System.out.println(daughter.toString());
        System.out.println(son.toString());
        System.out.println(cat.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this(name, sex, age);
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
