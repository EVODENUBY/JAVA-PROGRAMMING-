package Java_Assignment_3;

public class Adder {

    //Method overloading by changing nbr of arguments
        static int add(int a, int b){
        return a+b;
    }
    static int add(int a, int b, int c){
        return a+b+c;
    }

    //method overloading by changing DataType
    static double add(double a, double b){
        return a+b;
    }
}
class TestOverloading{
    public static void main(String []args){
        System.out.println("Two arguments: "+Adder.add(117.7,467.9));
        System.out.println("Three Arguments: "+Adder.add(117,467,780));
    }
}

