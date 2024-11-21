package Examples;

import java.util.Scanner;

class Library {
    // ***** Scanner ***********************************//

    public static Scanner input = new Scanner(System.in);

    //nextInt()    nextDouble()    nextBoolean()    nextLine()    next()

    // ***** Text Colors for the Console *****************//
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";




    public static int myRandom (int min, int max){
        int num =  (int) (Math.random() * (max - min + 1)   + min);
        return num;
    }//and random








}//class