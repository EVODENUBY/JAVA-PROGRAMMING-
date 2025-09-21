package com.entities;

public class Rectangle {
    public double l;
    public double w;

    public Rectangle(double l, double w) {
        this.l =l;
        this.w =w;
    }

    //Methods
    public double calculateArea(){
        return this.l* this.w;

    }
    public double calculatePerimeter(){
        return 2*(this.l+ this.w);
    }
    //add to string method
    public String toString(){
        return "Rectangle [length=" +l +", width= " +w + ", calculateArea()= "+calculateArea() + ", CalculatePerimeter= "+ calculatePerimeter()+ "]";
    }
}
