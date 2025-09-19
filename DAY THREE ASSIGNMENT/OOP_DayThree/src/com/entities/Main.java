package com.entities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String selection;

        do {
            System.out.println("Select A shape");
            System.out.println("----------------");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Square");
            System.out.println("4. Triangle");
            System.out.print("Enter Your choice: ");

            int choice = sc.nextInt();
            int chosen;
            switch (choice) {
                case 1:
                    System.out.println("\nRectangle");
                    System.out.println("What would you like to calculate? : ");
                    System.out.println("1. Calculate Area");
                    System.out.println("2. Calculate Perimeter");
                    System.out.print("Enter Your Choice: ");
                    chosen = sc.nextInt();
                    System.out.print("Enter the length: ");
                    double l = sc.nextDouble();
                    System.out.print("Enter the Width: ");
                    double w = sc.nextDouble();
                    Rectangle rc = new Rectangle(l, w);

                    if (chosen==1) {

                        System.out.println("The area of Rectangle is: " + rc.calculateArea());
                    } else if (chosen ==2) {
                        System.out.println("The area of Rectangle is: " + rc.calculatePerimeter());
                    }else {
                        System.out.println("Invalid Choice, Please select(1 or 2: ");
                    }
                case 2:
                    System.out.println("\nCircle");
                    System.out.println("What would you like to calculate? : ");
                    System.out.println("1. Calculate Area");
                    System.out.println("2. Calculate Circumference");
                    System.out.print("Enter Your Choice: ");
                    chosen =sc.nextInt();
                    System.out.print("Enter the Radius of circle: ");

                    double r=sc.nextDouble();

                    Circle cr= new Circle(r);
                    if (chosen==1) {
                        System.out.println("The area of Circle is: " + cr.calculateArea());
                    } else if (chosen==2) {
                        System.out.println("The Circumference of Circle is: "+cr.calculateCircumference());
                    }
                    else {
                        System.out.println("Invalid Choice, Please select(1 or 2: ");
                    }
                case 3:
                    System.out.println("\nSquare");
                    System.out.println("What would you like to calculate? : ");
                    System.out.println("1. Calculate Area");
                    System.out.println("2. Calculate Perimeter");
                    System.out.print("Enter Your Choice: ");
                    chosen =sc.nextInt();
                    System.out.print("Enter the side of Square: ");
                    double s = sc.nextDouble();
                    Square sr= new Square(s);
                    if(chosen==1){
                        System.out.println("The area of Square is: "+sr.calculateArea());

                    } else if(chosen ==2) {
                        System.out.println("The Perimeter of Square is: "+sr.calculatePerimeter());

                    }else {
                        System.out.println("Invalid Choice, Please select(1 or 2: ");
                    }
                case 4:
                    System.out.println("\nTriangle");
                    System.out.println("What would you like to calculate? : ");
                    System.out.println("1. Calculate Area");
                    System.out.println("2. Calculate Perimeter");
                    System.out.print("Enter Your Choice: ");
                    chosen = sc.nextInt();
                    System.out.print("Enter the base of triangle: ");
                   double b = sc.nextDouble();
                    System.out.print("Enter the height of triangle: ");
                    double h = sc.nextDouble();
                    System.out.print("Enter the hy of triangle: ");
                    double hy = sc.nextDouble();

                    Triangle tr= new Triangle(b,h,hy);
                    if(chosen==1){

                        System.out.println("The area of Triangle is: "+tr.calculateArea());

                    } else if(chosen ==2) {
                        System.out.println("The Perimeter of Triangle is: "+tr.calculatePerimeter());

                    }else {
                        System.out.println("Invalid Choice, Please select(1 or 2: ");
                    }
                    break;
                default:
                    System.out.println("Invalid");
            }

            System.out.print("Would you like to continue? (y/n): ?");
            selection = sc.next().toLowerCase();

        }while (selection.equals("y"));
            System.out.println("Thank You for Using Our system!");
        sc.close();

    }
}
