package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitry.Efimov on 22.06.2016.
 */
public class InfinityThread extends Thread {

    @Override
    public void run() {
        while (true){}
    }
}
