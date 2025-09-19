

import java.util.Scanner;

public class MultiPlayer_GuessingGameTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int a = 0; a < 1; a++) {
            int randomNumber = (int) (Math.random() * 101); // it is generating a random number from 0 to 100
            //System.out.println(randomNumber);
            boolean isCorrectP1 = false;
            boolean isCorrectP2 = false;
            int P1Tries=0;
            int P2Tries=0;
            for (int i = 0; i < 5; i++) {// this is to give the 5 repeated turns e.g. "5 more tries" until it says 1 more try
                System.out.println("Guess a number(1-100)(P1):");
                int guessedNumber;
                try { 
                    guessedNumber = sc.nextInt(); 
                } catch (Exception e) { // EXEPTION HANDLING --- Give message if they enter something thats not an int
                    System.out.println("Not an integer.\n" + e);// 
                    sc.next();
                    i--;
                    System.out.println(5 - i - 1 + " guesses remain.");
                    continue;
                }
                if (guessedNumber == randomNumber) { // checking if the user's number they guessed is correct
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    isCorrectP1 = true;
                    P1Tries=i-5;
                    break;
                } else if (guessedNumber > 100 || guessedNumber < 1) { //give messsage if number is >100 or <1
                    System.out.println("Not a number between 1 and 100.");
                    i--;
                } else {// if they gave a number <100 and >1 then if its also incorrect then say wrong
                    System.out.println("Wrong!");
                    if (guessedNumber < randomNumber) { // going on to the hints "5---> too small, go higher" or smth
                        System.out.println("The correct number is larger.");
                    } else {
                        System.out.println("The correct number is smaller.");
                    }
                }
                System.out.println(5 - i - 1 + " guesses remain."); // to say "4 guesses remain" or howevermany left
            } for (int i = 0; i < 5; i++) {// this is to give the 5 repeated turns e.g. "5 more tries" until it says 1 more try
                System.out.println("Guess a number(1-100)(P2):");
                int guessedNumber;
                try { 
                    guessedNumber = sc.nextInt(); 
                } catch (Exception e) { // EXEPTION HANDLING --- Give message if they enter something thats not an int
                    System.out.println("Not an integer.\n" + e);// 
                    sc.next();
                    i--;
                    System.out.println(5 - i - 1 + " guesses remain.");
                    continue;
                }
                if (guessedNumber == randomNumber) { // checking if the user's number they guessed is correct
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    isCorrectP2 = true;
                    P2Tries=i-5;
                    break;
                } else if (guessedNumber > 100 || guessedNumber < 1) { //give messsage if number is >100 or <1
                    System.out.println("Not a number between 1 and 100.");
                    i--;
                } else {// if they gave a number <100 and >1 then if its also incorrect then say wrong
                    System.out.println("Wrong!");
                    if (guessedNumber < randomNumber) { // going on to the hints "5---> too small, go higher" or smth
                        System.out.println("The correct number is larger.");
                    } else {
                        System.out.println("The correct number is smaller.");
                    }
                }
                System.out.println(5 - i - 1 + " guesses remain."); // to say "4 guesses remain" or howevermany left
            }
            if (!isCorrectP1) {
                System.out.printf("\nGood Try(P1)! The number was %d.", randomNumber); // if they never get it, it gives the right number
            }else{System.out.print("\nYou Won with "+P1Tries+" tries! (P1)");}if (!isCorrectP2) {
                System.out.printf("\nGood Try(P2)! The number was %d.", randomNumber); // if they never get it, it gives the right number
            }else{System.out.print("\nYou Won with "+P2Tries+" tries! (P2)");}

            System.out.println("Do you want to play again?(Y/N)"); // 
            String playAgain = sc.next();
            if (playAgain.equalsIgnoreCase("Y")) {
                a--; // this is the "i" of the for loop, so if tis gets minused then it will run again, so the entire game can be replayed
            }
        }//
        sc.close();
    }
}