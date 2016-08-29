package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
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
        int step;
        String delimiter;

        switch (firstArg) {
            case ("c"):
                if (!checkArgs(4, "name, sex, birthday", "create", args)) {
                    return;
                }
                step = 3;
                delimiter = "";
                for (int i = 1; i < args.length; i += step) {
                    System.out.print(delimiter + createPerson(args[i], args[i+1], sdf.parse(args[i+2])));
                    delimiter = " ";
                }
                return;
            case ("u"):
                if (!checkArgs(5, "id, name, sex, birthday", "update", args)) {
                    return;
                }
                step = 4;
                for (int i = 1; i < args.length; i += step) {
                    updatePerson(Integer.parseInt(args[i]), args[i+1], args[i+2], sdf.parse(args[i+3]));
                }
                return;
            case ("d"):
                if (!checkArgs(2, "id", "logical delete", args)) {
                    return;
                }
                for (int i = 1; i < args.length; i++) {
                    deletePerson(Integer.parseInt(args[i]));
                }
                return;
            case ("i"):
                if (!checkArgs(2, "id", "print", args)) {
                    return;
                }
                delimiter = "";
                for (int i = 1; i < args.length; i++) {
                    showPerson(Integer.parseInt(args[i]), delimiter);
                    delimiter = " ";
                }
                return;
            default:
                System.out.println("Wrong key. Use c for create; u for update; d for delete; i for print");
        }
    }

    private static boolean checkArgs(int number, String argList, String action, String ... args) {
        if (args.length < number || (args.length-1)%(number-1) != 0) {
            System.out.println("Wrong number of arguments. Use " + argList + "[, " + argList + ", ...] for " + action);
            return false;
        }
        return true;
    }

    private static synchronized void showPerson(int id, String delimeter) {
        System.out.print(delimeter + print(allPeople.get(id)));
    }

    private static String print(Person person) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Sex sex = person.getSex();
        String sexValue;
        if (sex == Sex.FEMALE) {
            sexValue = "ж";
        } else {
            sexValue = "м";
        }

        return (person.getName() + " " + sexValue + " " + sdf.format(person.getBirthDay()));
    }

    private static synchronized void deletePerson(int id) {
        allPeople.get(id).setSex(null);
    }

    private static synchronized void updatePerson(int id, String name, String sex, Date birthDate) {
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

    private static synchronized String createPerson(String name, String sex, Date birthDate) {
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, birthDate));
        } else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, birthDate));
        } else {
            System.out.println("Wrong sex definition. Use \"м\" or \"ж\"");
            return "";
        }

        return String.valueOf(allPeople.size()-1);
    }
}
