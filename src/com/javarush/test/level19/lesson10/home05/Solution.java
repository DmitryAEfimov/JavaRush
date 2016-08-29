package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }

        Solution application = new Solution();
        application.initStreams(args[0], args[1]);
    }

    private void initStreams(String inFile, String outFile) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String string;

        try {
            reader = new BufferedReader(new FileReader(inFile));
            writer = new BufferedWriter(new FileWriter(outFile));
            String delimiter = "";
            while ((string = reader.readLine()) != null) {

                for (String str : getWordsWithDigit(string)) {
                    writer.write(delimiter + str);
                    delimiter = " ";
                }
            }
        } finally {
            if (reader != null) reader.close();
            if (writer != null) writer.close();
        }
    }

    private List<String> getWordsWithDigit(String string) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");

        for (String str : string.split("\\s")) {
            if (pattern.matcher(str).find()) {
                list.add(str);
            }
        }

        return list;
    }
}
