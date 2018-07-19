package com.lfxfs.tools.pattern.decorator;


public class FoodDecoratorTest {
    public static void main(String[] args) {
        Food food = new Bread(new Cream(new Vegetable(new Food("热狗"))));
        System.out.println(food.make());
    }

}
