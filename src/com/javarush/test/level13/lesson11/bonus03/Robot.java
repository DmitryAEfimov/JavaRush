package com.javarush.test.level13.lesson11.bonus03;

import java.util.Random;

public class Robot extends AbstractRobot
{
    private Random rnd = new Random();

    public Robot(String name) {
        super(name);
    }

    public int getHitCount() {
        return rnd.nextInt(4);
    }
}
