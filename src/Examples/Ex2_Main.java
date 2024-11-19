package Examples;

import java.util.ArrayList;

public class Ex2_Main {
    public static void run(){

    ArrayList <Ex2_Actor> allActors = new ArrayList<>();

    allActors.add( new Ex2_Actor("Othello" , "Ms. Smith", true)    );
    allActors.add( new Ex2_Actor("Iago", "Mrs. Bone" )    );
    allActors.add( new Ex2_Actor("Cassio", "Ms. Shewchuk" )    );
    allActors.add( new Ex2_Actor("Desdemona", "Mr Hodkings", true  )    );
    allActors.add( new Ex2_Actor("Roderigo", "Ms. Lei" )    );


    allActors.get(1).sellTix(125);
    allActors.get(4).sellTix(76);

    String seller = "Ms. Smith";
    int sold = 50;

    int foundIndex = searchByName(allActors, seller);
    allActors.get(foundIndex).sellTix(sold);


        for (int i = 0; i < allActors.size() ; i++) {
//            System.out.println( allActors.get(i) ); //uses toString
//            System.out.println( allActors.get(i).role + "is played by " + allActors.get(i).name );
            allActors.get(i).printMe();
            System.out.println();
        }

        //calculate revenue
        int totalTix = 0;
        for (int i = 0; i <  allActors.size(); i++) {
            totalTix += allActors.get(i).sales;
        }
        System.out.println("We sold: " + totalTix + " tickets for a total of: " + totalTix*20);


    } //run

    public static int searchByName (ArrayList<Ex2_Actor> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).name )){
                return i;

            }
        }


        return -1;
    }

} // Ex2_main
