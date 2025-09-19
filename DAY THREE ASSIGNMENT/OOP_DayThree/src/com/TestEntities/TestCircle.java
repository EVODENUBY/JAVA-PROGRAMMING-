package com.TestEntities;

import com.entities.Circle;

public class TestCircle {
    public static void main(String[] args){
        Circle c = new Circle(5);
        System.out.println("AREA OF CIRCLE: "+c.calculateArea());
        System.out.println("Circumference OF CIRCLE: "+c.calculateCircumference());
        System.out.println(c.toString());
    }
}
