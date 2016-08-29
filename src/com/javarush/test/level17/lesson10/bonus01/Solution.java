package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        try {
            parseArgs(args);
        } catch (ParseException e) {
            System.out.println("Wrong date format. Use dd/MM/yyyy");
        }
    }

    private static void parseArgs(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String firstArg = args[0].substring(1);
        switch (firstArg) {
            case ("c"):
                if (!checkArgs(4, "name, sex, birthday for create", args)) {
                    return;
                }
                createPerson(args[1], args[2], sdf.parse(args[3])); return;

            case ("u"):
                if (!checkArgs(5, "id, name, sex, birthday for update", args)) {
                    return;
                }
                updatePerson(Integer.parseInt(args[1]), args[2], args[3], sdf.parse(args[4])); return;
            case ("d"):
                if (!checkArgs(1, "id for logical delete", args)) {
                    return;
                }
                deletePerson(Integer.parseInt(args[1])); return;
            case ("i"):
                if (!checkArgs(1, "id for print", args)) {
                    return;
                }
                showPerson(Integer.parseInt(args[1])); return;
            default:
                System.out.println("Wrong key. Use c for create; u for update; d for delete; i for print");
        }
    }

    private static boolean checkArgs(int number, String argList, String ... args) {
        if (args.length < number) {
            System.out.println("Wrong number of arguments. Use " + argList);
            return false;
        }
        return true;
    }

    private static void showPerson(int id) {
        print(allPeople.get(id));
    }

    private static void print(Person person) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Sex sex = person.getSex();
        String sexValue;
        if (sex == Sex.FEMALE) {
            sexValue = "ж";
        } else {
            sexValue = "м";
        }

        System.out.println(person.getName() + " " + sexValue + " " + sdf.format(person.getBirthDay()));
    }

    private static void deletePerson(int id) {
        allPeople.get(id).setSex(null);
    }

    private static void updatePerson(int id, String name, String sex, Date birthDate) {
        Person person = allPeople.get(id);
        Sex sexValue = null;
        person.setName(name);
        person.setBirthDay(birthDate);

        if (sex.equals("м")) {
            person.setSex(Sex.MALE);
        } else if (sex.equals("ж")) {
            person.setSex(Sex.FEMALE);
        } else {
            System.out.println("Wrong sex definition. Use \"м\" or \"ж\"");
        }
    }

    private static void createPerson(String name, String sex, Date birthDate) {
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, birthDate));
        } else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, birthDate));
        } else {
            System.out.println("Wrong sex definition. Use \"м\" or \"ж\"");
            return;
        }

        System.out.println(allPeople.size()-1);
    }
}
