package com.entities;

public class Square {
    private double s;
    public Square(double s){
        this.s =s;
    }


    public double calculateArea(){
        return this.s*this.s;
    }
    public double calculatePerimeter(){
        return this.s*4;
    }
}
