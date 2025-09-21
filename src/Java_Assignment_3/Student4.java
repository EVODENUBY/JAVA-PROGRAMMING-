package Java_Assignment_3;

public class Student4 {
    int id;
    String name;
    //Creating Constructors
    public Student4(int id, String name) {
        this.name =name;
        this.id =id;
    }

    //Method to display Those values
    public void display(){
        System.out.println(this.id+" "+this.name);
    }
    public  static void main(String []args){
        Student4 s1=new Student4(100,"evode");
        Student4 s2=new Student4(200,"Adolphe");
        s1.display();
        s2.display();
    }
}
