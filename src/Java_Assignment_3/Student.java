package Java_Assignment_3;

public class Student {
    int rollNo;
    int id;
    String name;
    static String college="INES RUHENGERI";

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    public static void changeCollege(){
            college ="UNIVERSITY OF RWWANDA";
    }

   public   void insertRecord(int r, String n) {
        this.rollNo = r;
        this.name =n;
    }

     public void displayInformation(){
        System.out.println(rollNo +" "+name);

    }
}
