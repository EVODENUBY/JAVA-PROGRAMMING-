package Java_Assignment_3;

public class Animal {
    public  void eat(){
        System.out.println("Eating............");
    }
}
//Single inheritance
 class Dog extends Animal{
    public void bark(){
        System.out.println("Barking..........");
    }
}

//Multi level inheritance
class BabyDog extends Dog{
    public  void weep(){
        System.out.println("weeping..........");
    }
}

//Hierarchical inheritance
class Cat extends Animal{
    public  void meow(){
        System.out.println("Meowing................");
    }
}
class TestInheritance{
    public static void main(String []args){
        Dog dog= new Dog();
        BabyDog babyDog= new BabyDog();
        Cat cat= new Cat();

        System.out.println("SIngle inheritance");
        dog.eat();
        dog.bark();

        System.out.println("\nMulti-level inheritance");
        babyDog.weep();
        babyDog.eat();
        babyDog.bark();

        System.out.println("\nHierarchical inheritance");
        cat.meow();
        cat.eat();

    }
}




