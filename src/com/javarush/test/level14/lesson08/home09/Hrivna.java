package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Dmitry.Efimov on 18.06.2016.
 */
public class Hrivna extends Money {
    private final String currencyName = "HRN";

    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return currencyName;
    }
}
