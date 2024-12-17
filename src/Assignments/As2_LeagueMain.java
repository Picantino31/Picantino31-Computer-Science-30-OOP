package Assignments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class As2_LeagueMain {


    public static void run() {
        ArrayList<As2_Team> allTeams = new ArrayList<>();


        loadFile("data/Data - Sheet1.csv", allTeams);

        //Barcelona
        allTeams.get(0).addPlayer("Lamine Yamal", 0, 5);
        allTeams.get(0).addPlayer("Robert Lewandowski", 1, 16);
        allTeams.get(0).addPlayer("Gavi", 2,0);
        allTeams.get(0).addPlayer("Pedri",3,3);
        allTeams.get(0).addPlayer("Dani Olmo",4,5);
        //Real Madrid
        allTeams.get(1).addPlayer("Kylian Mbappe",5, 2);
        allTeams.get(1).addPlayer("Vinicious Junior",6,8);
        allTeams.get(1).addPlayer("Jude Bellingham",7,6);

        //Atletico Madrid
        allTeams.get(2).addPlayer("Julian Alvarez",8, 5);
        allTeams.get(2).addPlayer("Antoine Griezmann",9, 5);

        //Athletic Club
        allTeams.get(3).addPlayer("Nico Williams",10,1);
        allTeams.get(3).addPlayer("Unai Simon",11,0);

        //Villarreal
        allTeams.get(4).addPlayer("Alex Baena",12,4);
        allTeams.get(4).addPlayer("Ayoze Perez",13, 7);

        // Mallorca
        allTeams.get(5).addPlayer("Takuma Asano",14, 0);
        allTeams.get(5).addPlayer("Cyle Larin",15, 4);

        //Osasuna
        allTeams.get(6).addPlayer("Ante Budimir",16, 10);

        //Racing Santander
        allTeams.get(7).addPlayer("Pablo Rodríguez",17, 2);

        //Almeria
        allTeams.get(8).addPlayer("Kaiky Fernandes",18, 0);

        //Mirandes
        allTeams.get(9).addPlayer("Unai Egiluz",19, 0);

        while (true) {
            System.out.println("\nWhat do you want to do?\n1.Print list of teams\n2.Find highest stats\n3.View division\n4.Sort by wins\n5.Update stats\n6.Print players\n7.Total player stats\n8.Update player stats\n9.Save and Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if (choice == 1) {
                //print data
                for (int i = 0; i < allTeams.size(); i++) {
                    System.out.println(allTeams.get(i).toString());
                }
            } else if (choice == 2) {
                //find highest
                int foundIndex = findHighestWins(allTeams);
                System.out.println(allTeams.get(foundIndex).getNicknames() + " has the most wins at " + allTeams.get(foundIndex).getTotalWins() + " wins");

                foundIndex = findHighestLosses(allTeams);
                System.out.println(allTeams.get(foundIndex).getNicknames() + " has the most losses at " + allTeams.get(foundIndex).getTotalLost() + " losses");

                foundIndex = findHighestIncome(allTeams);
                System.out.println(allTeams.get(foundIndex).getNicknames() + " has the highest overall transfer income at " + allTeams.get(foundIndex).getMoney() + " million euros");


            } else if (choice == 3) {
                System.out.println("What division do you want to filter by?");
                String ans = Library.input.nextLine();

                filterLeague(allTeams, ans);
            } else if (choice == 4){
                selectionSortIntArrayList(allTeams);

                for (int i = 0; i < allTeams.size(); i++) {
                    System.out.println(allTeams.get(i).getNicknames() + "has " + allTeams.get(i).getTotalWins() + " wins");
                }


            } else if (choice == 5) {
                System.out.println("Which team's name do you wanna update?");
                String response = Library.input.nextLine();

                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getNicknames().equalsIgnoreCase(response) ){

                        System.out.println("Choose a new name for " + allTeams.get(i).getNicknames() );
                        String newName = Library.input.nextLine();

                        allTeams.get(i).setNicknames(newName);

                    }
                }


            }
            else if(choice == 6){
                //print players
                System.out.println("What team's players do you want to see?");
                String ans = Library.input.nextLine();

                findPlayers(allTeams, ans);

            }else if(choice == 7) {

                for (int i = 0; i < allTeams.size(); i++) {
                    System.out.println( allTeams.get(i).getNicknames() + ": " + allTeams.get(i).totalScore() + " goals scored");
                }

            }else if(choice == 8) {
                System.out.println("What player's stats do you want to update?");
                String ans = Library.input.nextLine();

                System.out.println("How many goals did they score?");
                int goals = Library.input.nextInt();
                Library.input.nextLine();

                for (int i = 0; i < allTeams.size(); i++) {
                    allTeams.get(i).updateStat(ans, goals);
                }

            }

             else{
                //exit and save
                saveFile("data/Data - Sheet1.csv", allTeams);
                break;
            }



        }

    }


    public static void loadFile(String filename, ArrayList<As2_Team> list) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while (file.ready()) {
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
//the next line is customized for whatever class you are creating.
//Here we create a new STUDENT so there are 5 variables
//Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add(new As2_Team(tempArray[0], tempArray[1], tempArray[2], Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])));

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile

    public static void saveFile(String filename, ArrayList <As2_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";   //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getNicknames();
                toSave += "," + tempList.get(i).getCity();
                toSave +="," + tempList.get(i).getLeague();
                toSave +="," + tempList.get(i).getMoney();
                toSave +="," + tempList.get(i).getTotalWins();
                toSave +="," + tempList.get(i).getTotalLost();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile


    public static int findHighestWins(ArrayList<As2_Team> list) {
        int highestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(highestIndex).getTotalWins() < list.get(i).getTotalWins()) {
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest wins


    public static int findHighestLosses(ArrayList<As2_Team> list) {
        int highestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(highestIndex).getTotalLost() < list.get(i).getTotalLost()) {
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest losses


    public static int findHighestIncome(ArrayList<As2_Team> list) {
        int highestIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(highestIndex).getMoney() < list.get(i).getMoney()) {
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest losses

    public static void filterLeague(ArrayList<As2_Team> list, String filter) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLeague().equalsIgnoreCase(filter)) {
                System.out.println(list.get(i).getNicknames() + " " + list.get(i).getCity() + " " + list.get(i).getTotalWins() + " wins");
            }
        }

    }

    public static void findPlayers(ArrayList<As2_Team> list, String filter){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNicknames().equalsIgnoreCase(filter) ){
                list.get(i).printMyPlayers();
            }
        }

    }

    public static void selectionSortIntArrayList(ArrayList<As2_Team> list){
        for(int i=0; i<list.size()-1; i++){
            int highestIndex = i;
            for(int j=i+1; j<list.size(); j++){
                if(list.get(j).getTotalWins() > list.get(highestIndex).getTotalWins() ){
                    highestIndex = j;
                }
            }

            As2_Team tempTeam = list.get(i);
            list.set(i, list.get(highestIndex));
            list.set(highestIndex, tempTeam);

        }//end for i

    }//selection sort int
}

