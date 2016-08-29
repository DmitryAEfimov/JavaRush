package com.javarush.test.level16.lesson13.bonus02;

/**
 * Created by Dmitry.Efimov on 22.06.2016.
 */
public class HurrayThread extends Thread {
    private static final long SLEEP_TIME = 500;
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Ура");
                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException e) {

        }
    }
}
