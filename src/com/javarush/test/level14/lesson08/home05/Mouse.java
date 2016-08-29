package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Dmitry.Efimov on 17.06.2016.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
