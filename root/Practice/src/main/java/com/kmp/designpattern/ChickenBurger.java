package com.kmp.designpattern;

public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 12.9f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
