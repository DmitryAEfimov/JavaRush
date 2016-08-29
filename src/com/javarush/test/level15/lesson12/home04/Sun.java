package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Dmitry.Efimov on 20.06.2016.
 */
public final class Sun implements Planet {
    private static Sun instance = null;

    private Sun() {

    }

    public static synchronized Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }

        return instance;
    }
}
