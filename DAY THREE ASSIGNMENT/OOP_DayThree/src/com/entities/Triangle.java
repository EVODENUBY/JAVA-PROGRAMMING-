package com.entities;
public class Triangle {
    private double b;
    private double h;
    private double hy;
    public Triangle(double b, double h, double hy){
        this.b =b;
        this.h =h;
        this.hy =hy;
    }


    public double calculateArea(){
        return (this.b*this.h)/2;
    }
    public double calculatePerimeter(){
        return this.b+this.h+this.hy;
    }
}