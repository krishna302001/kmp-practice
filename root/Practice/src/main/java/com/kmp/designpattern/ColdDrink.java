package com.kmp.designpattern;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing(){
        return new Bottle();
    }

    public abstract float price();

}
