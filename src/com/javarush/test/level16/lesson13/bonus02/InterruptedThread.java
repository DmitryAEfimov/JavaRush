package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitry.Efimov on 22.06.2016.
 */
public class InterruptedThread extends Thread {
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
            }
            throw new InterruptedException("InterruptedException");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
