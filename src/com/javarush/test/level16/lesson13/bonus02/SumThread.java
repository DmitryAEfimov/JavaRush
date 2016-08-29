package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Dmitry.Efimov on 22.06.2016.
 */
public class SumThread extends Thread {
    int sum;
    static BufferedReader reader;
    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = reader.readLine();
                if ("N".equals(str)) break;
                sum += Integer.parseInt(str);
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
