package Assignments;

public class As3_Player {
    private String name;
    private int playerID;
    private int goalScored;


    public As3_Player(String n, int i, int g){
        name = n;
        playerID = i;
        goalScored = g;


    }//constructor

    public String toString(){
        return name + " has scored " + goalScored + " goals. " + "Player ID:" + playerID;
    }//to string

    public int getGoalScored() {
        return goalScored;
    }

    public String getName() {
        return name;
    }

    public void addGoals(int g){
        goalScored += g;
    }//update stats



}//class
