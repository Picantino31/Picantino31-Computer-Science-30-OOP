package Assignments;

import Examples.Ex2_Actor;


import java.util.ArrayList;

public class As1_Main {

    public static void run(){
        ArrayList<As1_Crop> allCrops = new ArrayList<>();

        //variables
        double totalRevenue = 0;

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




        //looping menu
        System.out.println("Welcome to Philip's Farm!");

        while(true){
            System.out.println("\nWhat do you want to do?\n1.Print farm summary\n2.Search & harvest a crop\n3.Total Revenue\n4.Plant crops\n5.Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if(choice == 1){

                //print crops
                for (int i = 0; i < allCrops.size(); i++) {
                    System.out.println(allCrops.get(i).printMe());
                }

            }else if(choice == 2){

                //search for crop
                System.out.println("What crop do you want to search for?");
                String crop = Library.input.nextLine();

                int foundIndex = searchByName(allCrops, crop);

                if(foundIndex == -1){
                    System.out.println("Crop not found, try again.");
                }else{
                    System.out.println(allCrops.get(foundIndex).printMe() );

                    //harvest crop
                    System.out.println("Would you like to harvest your " + allCrops.get(foundIndex).getName() + " (yes/no)");
                    String ans = Library.input.nextLine();

                    if( ans.equalsIgnoreCase("yes") ){
                        totalRevenue += allCrops.get(foundIndex).harvest();
                    }else{
                        System.out.println("No crops harvested");
                    }

                }//end else

            }else if(choice == 3){

                //Print total revenue
                System.out.println("Total revenue from all harvested crops: $" + totalRevenue);

            }else if(choice == 4){

                //Plant a crop
                System.out.println("What crop do you want to plant?");
                String crop = Library.input.nextLine();

                int foundIndex = searchByName(allCrops, crop);

                if(foundIndex == -1){

                    //create new data for new crop
                    System.out.println("How many acres would you like to plant?");
                    int a = Library.input.nextInt();
                    Library.input.nextLine();

                    System.out.println("How much does it yield? (double)");
                    double y = Library.input.nextDouble();
                    Library.input.nextLine();

                    System.out.println("What are the units for yield? (String)");
                    String u = Library.input.nextLine();

                    System.out.println("What is the price per unit? (double)");
                    double p = Library.input.nextDouble();
                    Library.input.nextLine();

                    allCrops.add( new As1_Crop(crop, y, u, p) );
                    allCrops.getLast().setAcres(a);


                }else{
                    //plant existing crop
                    System.out.println("How many acres would you like to plant?");
                    int ans = Library.input.nextInt();
                    Library.input.nextLine();

                    allCrops.get(foundIndex).plantCrop(ans);

                }

            }else{
                break;
            }

        }//while true



    }//run


    public static int searchByName (ArrayList<As1_Crop> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).getName() )){
                return i;

            }
        }

        return -1;
    }//search by name


}//class