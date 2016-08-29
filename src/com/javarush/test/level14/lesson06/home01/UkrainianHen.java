package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Dmitry.Efimov on 17.06.2016.
 */
public class UkrainianHen extends Hen implements Country {

    @Override
    public int getCountOfEggsPerMonth() {
        countOfEggsPerMonth = rnd.nextInt(MAX_NUMBER_OF_EGGS) + 1;
        return countOfEggsPerMonth;
    }

    @Override
    public String getDescription() {
        String eggs = String.valueOf(countOfEggsPerMonth);
        return super.getDescription() + descrExtention.replace("<COUNTRY>", Country.UKRAINE).replace("<EGGS>", eggs);
    }
}
