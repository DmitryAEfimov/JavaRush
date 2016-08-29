package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("Степа", 16, "Улица");
        Man man2 = new Man("Вася", 89, "3-я улица Строителей, д.15");

        Woman woman1 = new Woman("Галя", 193, "СССР");
        Woman woman2 = new Woman("Клава", 5, "д. Пупкино");
        //выведи их на экран тут
        man1.getPerson();
        man2.getPerson();
        woman1.getPerson();
        woman2.getPerson();
    }

    //добавьте тут ваши классы
    public static class Man {
       // private final int DEFAULT_AGE = 35;
        private String name;
        private int age;
        private String address;

       /* public Man(String name) {
            this.name = name;
            this.age = DEFAULT_AGE;
        }

        public Man(String name, int age) {
            this.name = name;
            this.age = age;
        }*/

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

       /* public Man(String name, String address) {
            this.name = name;
            this.age = DEFAULT_AGE;
            this.address = address;
        }*/

        public void getPerson() {
            System.out.println("[" +name + " " + age + " " + address + "]");
        }

    }

    public static class Woman {
       // private final int DEFAULT_AGE = 35;
        private String name;
        private int age;
        private String address;

        /*public Woman(String name) {
            this.name = name;
            this.age = DEFAULT_AGE;
        }

        public Woman(String name, int age) {
            this.name = name;
            this.age = age;
        }*/

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

       /* public Woman(String name, String address) {
            this.name = name;
            this.age = DEFAULT_AGE;
            this.address = address;
        }*/

        public void getPerson() {
            System.out.println("["+name + " " + age + " " + address+"]");
        }

    }
}
