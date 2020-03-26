package com.kmp.designpattern;

public class BuilderPatternDemo {
    public static void main(String args[]){
        MealBuilder builder = new MealBuilder();

        Meal vegmeal= builder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegmeal.showItems();
        System.out.println("Total cost: "+vegmeal.getCost());

        System.out.println();

        Meal nonVegMeal = builder.prepareNonVegMeal();
        System.out.println("Non Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total cost: "+nonVegMeal.getCost());
    }
}
