package com.lfxfs.tools.pattern.decorator;


import org.junit.Test;

public class FoodDecoratorTest {

    @Test
    public void testFoodDecorator(){
        Food food = new Bread(new Cream(new Vegetable(new Food("热狗"))));
        System.out.println(food.make());
    }

}
