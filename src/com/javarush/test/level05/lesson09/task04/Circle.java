package com.javarush.test.level05.lesson09.task04;

/* Создать класс Circle
Создать класс (Circle) круг, с тремя конструкторами:
- centerX, centerY, radius
- centerX, centerY, radius, width
- centerX, centerY, radius, width, color
*/

public class Circle
{
    //напишите тут ваш код
    private final int DEFAULT_WIDTH = 1;
    private final String DEFAULT_COLOR = "white";

    private double centerX;
    private double centerY;
    private double radius;
    private int width;
    private String color;

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = DEFAULT_WIDTH;
        this.color = DEFAULT_COLOR;
    }

    public Circle(double centerX, double centerY, double radius, int width) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = DEFAULT_COLOR;
    }

    public Circle(double centerX, double centerY, double radius, int width, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.width = width;
        this.color = color;
    }
}
