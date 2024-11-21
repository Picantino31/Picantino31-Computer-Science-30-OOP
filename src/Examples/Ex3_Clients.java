package Examples;

public class Ex3_Clients {

    private String name;
    private String address;
    private int lawnSize;
    private  boolean hasDog;
    private double outstandingFees;


    //constructor method
    public Ex3_Clients( String n, String a, int s, boolean d){
        name = n;
        address = a;
        lawnSize = s;
        hasDog = d;
        outstandingFees = 0;
    }

    //Instance Methods
    public String toString(){
        return name + " " + address + " " + lawnSize + " " + outstandingFees;
    }

    public void mowLawn(){

        double baseFee = 20;
        if(lawnSize < 300){
            baseFee += 0.1 *lawnSize;

        }
        else{
            baseFee += 0.15 * lawnSize;
        }

        if(hasDog){
            baseFee += 40;
        }

        outstandingFees += baseFee;

        System.out.println(name + " your lawn was mowed today for a charge of $" + baseFee);
        System.out.println("Your currently owe: " + outstandingFees);
        System.out.println();

    }//mowLawn

    public  void processPayment(double dollars){
        outstandingFees -= dollars;
        System.out.println(name + " you currently owe $" + outstandingFees);
    }


    public String getName() {
        return name;
    }

    public void deliquent(){
        if(outstandingFees > 800) {
            double interest = 10 + outstandingFees * 0.5;
            outstandingFees += interest;
            System.out.println(name + "your payment is overdue. You have been charged interest of $" + interest);

            if(hasDog){
                hasDog = false;
            }

        }

    }



}
