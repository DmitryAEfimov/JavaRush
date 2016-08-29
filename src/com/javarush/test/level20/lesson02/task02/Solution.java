package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            User he = new User();
            he.setFirstName("Дмитрий");
            he.setLastName("Ефимов");
            he.setMale(true);
            he.setCountry(User.Country.RUSSIA);
            he.setBirthDate(sdf.parse("24/02/1981"));
            javaRush.users.add(he);

            User she = new User();
            she.setFirstName("Анастасия");
            she.setLastName("Ефимова");
            she.setMale(false);
            she.setCountry(User.Country.RUSSIA);
            she.setBirthDate(sdf.parse("21/04/1982"));
            javaRush.users.add(she);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            if (users.size() > 0) {
                for (User user : users) {
                    writer.println(user.getFirstName());
                    writer.println(user.getLastName());
                    writer.println(sdf.format(user.getBirthDate()));
                    writer.println(user.isMale());
                    writer.println(user.getCountry().getDisplayedName());
                    writer.flush();
                }
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            int linesToRead = Integer.parseInt(reader.readLine());

            if (linesToRead > 0) {
                for (int i = 0; i < linesToRead; i++) {
                    User user = new User();
                    users.add(user);

                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(sdf.parse(reader.readLine()));
                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    String countryString = reader.readLine();
                    for (User.Country country : User.Country.values()) {
                        if (country.getDisplayedName().equals(countryString)) {
                            user.setCountry(country);
                            break;
                        }
                    }
                }
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof JavaRush) || users.size() != ((JavaRush) obj).users.size()) {
                return false;
            } else {
                JavaRush compared = (JavaRush) obj;
                for (int i = 0; i < users.size(); i++) {
                    if (!(users.get(i).getFirstName().equals((compared.users.get(i).getFirstName())) &&
                         users.get(i).getLastName().equals((compared.users.get(i).getLastName())) &&
                         users.get(i).isMale() == (compared.users.get(i).isMale()) &&
                         users.get(i).getBirthDate().toString().equals((compared.users.get(i).getBirthDate().toString())) &&
                         users.get(i).getCountry().getDisplayedName().equals((compared.users.get(i).getCountry().getDisplayedName()))))
                        return false;
                }

                return true;
            }
        }
    }
}
