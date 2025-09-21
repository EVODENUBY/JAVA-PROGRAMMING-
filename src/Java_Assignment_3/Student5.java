package Java_Assignment_3;

public class Student5 {

    private  int age;
    int id;
    String name;
    //Creating two arg Constructor
        public Student5( int id, String name) {
            this.name =name;
            this.id =id;
        }
        //creating 3 arg constructor
        public Student5(int id, String name,int age ) {

            this.name = name;
            this.id = id;
            this.age =age;
        }
    //Method to display Those values
        public void display(){
            System.out.println(this.id+" "+this.name+" "+this.age);
        }
        public  static void main(String []args){
            Student5 s1=new Student5(100,"EVODE");
            Student5 s2=new Student5(200,"Adolphe",20);
            s1.display();
            s2.display();
        }
    }


