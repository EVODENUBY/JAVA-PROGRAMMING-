package Java_Assignment_3;

public class TestStudent3 {
    public static void main(String[] args){
        //Creating objects
        Student s1= new Student(100, "EVODE SANO");
        Student s2= new Student(200, "NAYITURIKI ADOLHE");
        Student s3= new Student(300, "SANO");

//        //Initializing objects
//        s1.id =1;
//        s1.name ="Evode Muyisingize";
//        s2.id =2;
//        s2.name ="Adolphe NAYITURIKI";
//        s3.id =3;
//        s3.name ="Bernard MUCYO";

        System.out.println("id: "+s1.id + " Name: "+s1.name);
        System.out.println("id: "+s2.id + " Name: "+s2.name);
        System.out.println("id: "+s3.id + " Name: "+s3.name);

    }
}
