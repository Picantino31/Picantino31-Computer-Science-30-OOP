package Assignments;


import java.util.ArrayList;

public class As1_Main {

    public static void run(){
        ArrayList<As1_Crop> allCrops = new ArrayList<>();

        //adding crops to arraylist
        allCrops.add( new As1_Crop("Sugar beets", 34.9, "tonnes per acre", 38.77) );
        allCrops.add( new As1_Crop("Canola", 38.1, "bushels per acre", 13.95) );
        allCrops.add( new As1_Crop("Barley", 75.9, "bushels per acre", 5.25) );
        allCrops.add( new As1_Crop("Lentils", 22.4, "bushels per acre", 0.28) );
        allCrops.add( new As1_Crop("Oats", 90.9, "bushels per acre", 3.68) );

        //Setting acres
        allCrops.get(0).setAcres(485);
        allCrops.get(1).setAcres(75);
        allCrops.get(2).setAcres(150);
        allCrops.get(3).setAcres(250);
        allCrops.get(4).setAcres(40);



        System.out.println("Welcome to Aaron's Farm");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Farm Summary ");
            System.out.println("2.  Search and Harvest a Crop");
            System.out.println("3.  Get Total Revenue");
            System.out.println("4.  Plant a crop");
            System.out.println("6.  Save and Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {
                for (int i = 0; i < allCrops.size(); i++) {
                    System.out.println(allCrops.get(i).toString());
                }

            }



            }
    }//run

}//class