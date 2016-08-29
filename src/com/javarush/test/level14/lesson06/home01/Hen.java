package com.javarush.test.level14.lesson06.home01;

import java.util.Random;

/**
 * Created by Dmitry.Efimov on 17.06.2016.
 */
public abstract class Hen {
    protected final int MAX_NUMBER_OF_EGGS = 30;

    protected int countOfEggsPerMonth;
    protected Random rnd = new Random();
    protected String descrExtention = " Моя страна - <COUNTRY>. Я несу <EGGS> яиц в месяц.";

    public abstract int getCountOfEggsPerMonth();

    public String getDescription() {
        return "Я курица.";
    }
}
