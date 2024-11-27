package Assignments;

public class As1_Crop {

    private String name;
    private double yield;
    private String units;
    private double price;
    private int acres;


    //constructor method
    public As1_Crop(String n, double y, String u, double p){
        name = n;
        yield = y;
        units = u;
        price = p;
        acres = 0;

    }//constructor

    public String getName() {
        return name;
    }

    public String printMe(){
        return name + " yield " + yield + " " + units + " and sell for $" + price + ". You have " + acres + " acres.";
    }//toString


    public void setAcres(int acres) {
        this.acres = acres;
    }//set acres


    public double harvest(){
        double revenue = price * yield * acres;//calculate revenue before setting acres to zero
        System.out.println("Harvest value : $" + revenue );
        acres = 0;
        return revenue;
    }//harvest


    public void plantCrop(int a){
        acres += a;
    }//plant existing crop


//    public void plantCrop(int a, double y, String u, double p){
//
//    }//plant new crop


}//class