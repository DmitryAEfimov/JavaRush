package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Dmitry.Efimov on 20.06.2016.
 */
public final class Earth implements Planet {
    private static Earth instance = null;

    private Earth() {

    }

    public static synchronized Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }

        return instance;
    }
}
