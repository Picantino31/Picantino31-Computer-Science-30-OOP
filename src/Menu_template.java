

public class Menu_template {
        public static void run() {


            while(true) {

                System.out.println("Press 1 for rock\nPress 2 to for country\nPress 3 for jazzy grooves\nPress 4 to exit.");


                int choice = Library.input.nextInt();
                Library.input.nextLine();

                if (choice == 1) {
                    System.out.println("Let's rock!");

                }
                if (choice == 2) {
                    System.out.println("Yeehaw!");
                }
                if (choice == 3) {
                    System.out.println("Cool dadio!");
                }
                if (choice == 4) {
                    break;
                }
                System.out.println();

            }//while

            System.out.println("Good bye");

        }//run
    }//MenuTemplate

