package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitry.Efimov on 22.06.2016.
 */
public class MessageThread extends Thread implements Message {

    @Override
    public void showWarning() {
        try {
            interrupt();
            join();
            System.out.println(isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {}
    }
}
