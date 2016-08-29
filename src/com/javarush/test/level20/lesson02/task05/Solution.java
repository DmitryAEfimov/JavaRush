package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу

        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4


            loadedObject.load(inputStream);

            System.out.println(object.equals(loadedObject));

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


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            System.setOut(new PrintStream(byteArrayOutputStream));

            string1.print();
            string2.print();

            byteArrayOutputStream.writeTo(outputStream);

            byteArrayOutputStream.close();
            System.setOut(consoleStream);
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            java.lang.String str = reader.readLine();
            int cnt = Integer.parseInt(str.replace("string #", "").trim());
            int rememberCountStrings = countStrings;
            countStrings = cnt-1;
            string1 = new String();
            string2 = new String();
            countStrings = rememberCountStrings;

            reader.close();
        }

        @Override
        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof Object)) return false;

            Object comparedObj = (Object) obj;
            PrintStream consoleStream = System.out;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(byteArrayOutputStream));

            string1.print();
            java.lang.String str1 = byteArrayOutputStream.toString();
            byteArrayOutputStream.reset();

            string2.print();
            java.lang.String str2 = byteArrayOutputStream.toString();
            byteArrayOutputStream.reset();

            comparedObj.string1.print();
            java.lang.String comparedStr1 = byteArrayOutputStream.toString();
            byteArrayOutputStream.reset();

            comparedObj.string2.print();
            java.lang.String comparedStr2 = byteArrayOutputStream.toString();

            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {

            }

            System.setOut(consoleStream);

            return str1.equals(comparedStr1) && str2.equals(comparedStr2);
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }
}
