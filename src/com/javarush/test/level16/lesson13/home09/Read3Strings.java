package com.javarush.test.level16.lesson13.home09;

import java.io.IOException;

/**
 * Created by Dmitry.Efimov on 21.06.2016.
 */
public class Read3Strings extends Thread {
    private String[] strings = new String[3];

    @Override
    public void run() {
        for (int i = 0; i < strings.length; i++) {
            try {
                strings[i] = Solution.reader.readLine();
            } catch (IOException e) {

            }
        }
    }

    @Override
    public String toString() {
        String delimeter = "";
        String fullString = "";
        for (String str : strings) {
            fullString += delimeter + str;
            delimeter = " ";
        }
        return fullString;
    }
}
