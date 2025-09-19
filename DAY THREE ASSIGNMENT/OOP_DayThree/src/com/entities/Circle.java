package com.entities;

public class Circle {

    private   double r;

    public Circle(double r){
            this.r =r;
        }



    public double calculateArea(){
        return Math.PI*r*r;
    }
    public double calculateCircumference(){
        return 2*Math.PI*r;
    }

    public String toString(){
        return  "Circle [Radius=" +r +", calculateArea()= "+calculateArea() + ", CalculateCircumference= "+ calculateCircumference()+ "]";
    }
}
