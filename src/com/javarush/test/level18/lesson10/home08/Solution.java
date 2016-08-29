package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                String fileName = reader.readLine();
                if ("exit".equals(fileName)) break;

                new ReadThread(fileName).run();
            }
            System.out.println(resultMap);
        } finally {
            if (reader != null) reader.close();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        private FileInputStream fis;
        private HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        public ReadThread(String fileName) throws IOException {
            super(fileName);
            this.fileName = fileName;
            this.fis = new FileInputStream(fileName);
        }

        @Override
        public void run() {
            try {
                processStream();

                resultMap.put(fileName, getFrequentestByte());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void processStream() throws IOException {
           try {
                while (fis.available() > 0) {
                    int read = fis.read();
                    if (!frequencyMap.containsKey(read)) frequencyMap.put(read, 0);

                        int value = frequencyMap.get(read);
                        frequencyMap.put(read, ++value);
                    }
                System.out.println(frequencyMap);
            } finally {
                if (fis != null) fis.close();
            }
        }

        public Integer getFrequentestByte() {
            int maxKey = Integer.MIN_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (value > maxValue) {
                    maxKey = key;
                    maxValue = value;
                }
            }
            return maxKey;
        }
    }
}
