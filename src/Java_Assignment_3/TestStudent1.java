package Java_Assignment_3;

public class TestStudent1 {

    public static void main(String [] args){
        Student.college ="UR";
        Student s1= new Student(100, "EVODE SANO");
        System.out.println("Student ID: "+s1.id +" "+Student.college);
        System.out.println("Student name: "+s1.name);
    }
}
