package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Dmitry.Efimov on 20.06.2016.
 */
public final class Moon implements Planet {
    private static Moon instance = null;

    private Moon() {

    }

    public static synchronized Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }

        return instance;
    }
}
