package Java_Assignment_3;

public class Vehicle {
    public void run(){
        System.out.println("Vehicle is running");
    }
    public static void main(String[]args){
        Bike bike= new Bike();
        bike.run();
    }

}

class Bike extends Vehicle{

    public void run(){
        System.out.println("Bike is running");
    }

}

