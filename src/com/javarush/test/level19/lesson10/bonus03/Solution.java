package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private StringBuilder stringBuilder = new StringBuilder();

    private String fileName;
    private String tagName;

    public static void main(String[] args) throws IllegalArgumentException, IOException {
        Solution application = new Solution();
        if (args.length < 1) {
            throw new IllegalArgumentException("Wrong number of arguments");
        } else if (args[0].contains("CDATA")) {
            throw new IllegalArgumentException("Tag contains \"CDATA\"");
        }

        application.tagName = args[0];
        application.initFile();
        application.readFile(application.fileName);
        application.parseTags(application.stringBuilder.toString());
    }

    private void parseTags(String str) {
        Matcher matcher = Pattern.compile("</?" + tagName + ".*?>").matcher(str);
        int tagCount = 0;
        int currentTagStart = -1;
        int nestedTagsStart = -1;
        int nestedTagsEnd = -1;
        boolean isNextTagBegins = false;
        String closeTagTemplate = "";

        while (matcher.find()) {
            if (!matcher.group().contains("/")) {
                tagCount++;

                if (!isNextTagBegins) {
                    if (tagCount == 1) {
                        currentTagStart = matcher.start();
                        closeTagTemplate = "</"+matcher.group().substring(1, tagName.length()+1)+">";
                    } else {
                        isNextTagBegins = true;
                        if (nestedTagsEnd == -1)
                            nestedTagsStart = matcher.start();
                    }
                }
            }

            if (matcher.group().contains("/")) {
                tagCount--;

                if (tagCount == 1 && isNextTagBegins) {
                    isNextTagBegins = false;
                    nestedTagsEnd = matcher.end();
                }
            }

            if (tagCount == 0) {
                if (closeTagTemplate.equals(matcher.group())) {
                    System.out.println(str.substring(currentTagStart, matcher.end()));
                }
                currentTagStart = -1;
                if (nestedTagsStart != -1 && nestedTagsEnd != -1) {
                    parseTags(str.substring(nestedTagsStart, nestedTagsEnd));
                    nestedTagsStart = -1;
                    nestedTagsEnd = -1;
                }
            }
        }
    }

    private void readFile(String fileName) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));

            while (reader.ready()) stringBuilder.append(reader.readLine());
        } finally {
            if (reader != null) reader.close();
        }
    }

    private void initFile() throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
        } finally {
            if (reader != null) reader.close();
        }
    }
}
