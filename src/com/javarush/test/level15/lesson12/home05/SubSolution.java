package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Dmitry.Efimov on 20.06.2016.
 */
public class SubSolution extends Solution {
    public SubSolution() {}
    public SubSolution(Double dbl) {super(dbl);}
    public SubSolution(Float flt) {super(flt);}

    private SubSolution(Integer integer) {}
    private SubSolution (Object obj) {}
    private SubSolution (String str) {}

    SubSolution(Object obj1, Object obj2) {super(obj1, obj2);}
    SubSolution(Integer integer1, Integer integer2) {super(integer1, integer2);}
    SubSolution(String str1, String str2) {super(str1, str2);}

    protected SubSolution(String... args) {super(args);}
    protected SubSolution(Integer... args) {super(args);}
    protected SubSolution(Object... args) {super(args);}
}
