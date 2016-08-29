package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код
    private final double DEFAULT_SIZE = 1;
    private double top;
    private double left;
    private double width;
    private double heigth;

    public Rectangle(Rectangle rect) {
        this.top = rect.top;
        this.left = rect.left;
        this.width = rect.width;
        this.heigth = rect.heigth;
    }

    public Rectangle(double top, double left, double width, double heigth) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.heigth = heigth;
    }

    public Rectangle(double top, double left) {
        this.top = top;
        this.left = left;
        this.width = DEFAULT_SIZE;
        this.heigth = DEFAULT_SIZE;
    }

    public Rectangle(double top, double left, double width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.heigth = width;
    }

    public Rectangle(double top, double left, double width, boolean isSquare) {
        this.top = top;
        this.left = left;
        this.width = width;

        if (isSquare)
            this.heigth = width;
        else
            this.heigth  =DEFAULT_SIZE;
    }
}
