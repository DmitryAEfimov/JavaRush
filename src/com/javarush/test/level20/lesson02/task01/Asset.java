package com.javarush.test.level20.lesson02.task01;

public class Asset {
    public Asset(String name) {
        this.name = name;
    }

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Asset)
            return name.equals(((Asset) obj).getName()) && price == ((Asset) obj).getPrice();
        else
            return false;
    }
}
