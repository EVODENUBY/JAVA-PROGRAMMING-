package Java_Assignment_3;

public class TestStudent4 {
    public static void main(String[] args){
        Student s1= new Student(100,"EVODE");
        Student s2= new Student(200, "ADOLPHE");
        s1.insertRecord(100, "Evode");
        s2.insertRecord(200, "Adolphe");

        //Display info
        s1.displayInformation();
        s2.displayInformation();
    }
    }

