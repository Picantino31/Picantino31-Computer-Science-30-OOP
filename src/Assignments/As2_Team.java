package Assignments;

import java.util.ArrayList;

public class As2_Team {
    private String nicknames;
    private String city;
    private String league;
    private double money;
    private int TotalWins;
    private int TotalLost;
    private ArrayList<As3_Player> allPlayers = new ArrayList<>();

    public As2_Team(String n, String c, String le, double m, int w, int l ){
        nicknames = n;
        city = c;
        league = le;
        money = m;
        TotalWins = w;
        TotalLost = l;
    }

    public String getNicknames() {
        return nicknames;
    }

    public void printMyPlayers(){
        for (int i = 0; i < allPlayers.size(); i++) {
            System.out.println( allPlayers.get(i).toString() );
        }
    }

    public String getCity() {
        return city;
    }

    public String getLeague() {
        return league;
    }

    public double getMoney() {
        return money;
    }

    public int getTotalWins() {
        return TotalWins;
    }

    public int getTotalLost() {
        return TotalLost;
    }

    public void setNicknames(String nicknames) {
        this.nicknames = nicknames;
    }

    public int totalScore(){
        int total = 0;
        for (int i = 0; i < allPlayers.size(); i++) {
            total += allPlayers.get(i).getGoalScored();
        }
        return total;
    }

    public String toString(){
        return nicknames + " is based in " + city + ". They play in the " + league + " and have a current value of " + money + " million euros. In the 23/24 season they won " + TotalWins + " games and lost " + TotalLost;
    }//to string

    public void addPlayer(String n, int p, int g){
        allPlayers.add( new As3_Player(n, p, g) );
    }//add player

    public void updateStat(String ans, int g){
        for (int i = 0; i < allPlayers.size(); i++) {
            if( ans.equalsIgnoreCase( allPlayers.get(i).getName() ) ){
                allPlayers.get(i).addGoals(g);
            }
        }//end for i
    }//update player stats


}
