package Java_Assignment_3;

public class Bank {
   public float getRateOfInterest(){
        return 0;
    }
}
class Bk extends Bank{
    @Override
    public float getRateOfInterest() {
        return 17;
    }
}
class EquityBank extends Bank{
    @Override
    public float getRateOfInterest() {
        return 18;
    }
}
class AXIS extends Bank{
    @Override
    public float getRateOfInterest() {
        return 9;
    }
}
class  TestBank{
    public static void main(String[]args){
        Bk bk=new Bk();
        EquityBank eq=new EquityBank();
        AXIS x=new AXIS();

        System.out.println("BK Rate of interest: "+bk.getRateOfInterest()+"%");
        System.out.println("EquityBank Rate of interest: "+eq.getRateOfInterest()+"%");
        System.out.println("AXIS Rate of interest: "+x.getRateOfInterest()+"%");
    }

}


