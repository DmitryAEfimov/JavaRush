package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Dmitry.Efimov on 20.06.2016.
 */
public class LatteMaker extends DrinkMaker {
    @Override
    public void getRightCup() {
        System.out.println("Берем чашку для латте");
    }

    @Override
    public void putIngredient() {
        System.out.println("Делаем кофе");
    }

    @Override
    public void pour() {
        System.out.println("Заливаем молоком с пенкой");
    }
}
