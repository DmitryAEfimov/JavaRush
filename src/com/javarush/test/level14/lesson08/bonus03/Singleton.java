package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Dmitry.Efimov on 18.06.2016.
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton() {
        //noting to do
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }

        return singleton;
    }


}
