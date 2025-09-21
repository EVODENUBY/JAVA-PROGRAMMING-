package Java_Assignment_3;

public class Emp {
    int id;
    String name;
    Address address;

    public Emp(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public void display(){
        System.out.println(id +" "+name);
        System.out.println(address.city+" "+address.state+" "+address.country);
    }
    public static void main(String []args){
        Address address1= new Address("Kigali","Rwanda","Rwanda");
        Address address2= new Address("Kampala","Malala","Uganda");

        Emp e= new Emp(100,"EVODE",address1);
        Emp e1= new Emp(200,"Adolphe",address2);
        e.display();
        e1.display();

    }

}
