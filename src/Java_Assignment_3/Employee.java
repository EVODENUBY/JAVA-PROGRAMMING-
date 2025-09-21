package Java_Assignment_3;

public class Employee {
    String name;
    float salary =100000;
    int id;

    public void insertInfo(int id, String n, float s){
        this.id =id;
        this.salary =s;
        this.name =n;
    }
    public void display(){
        System.out.println(this.id+" "+this.name+" "+this.salary);
    }

}
class Programmer extends Employee{
    int bonus =10000;
    public static void main(String []args){
        Programmer p=new Programmer();
        System.out.println("Programmer salary is: "+p.salary);
        System.out.println("Programmer Bonus is: "+p.bonus);
    }
}