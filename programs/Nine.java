package assignment1.programs;

import java.util.Random;
import java.util.Scanner;

public class Nine {
  public static void compareResult(int number1, int number2){
    if(number1 > 9){
      System.out.println("You got fat, you loose!");
      if(number2 > 9){
        System.out.print("But rest assure, Computer also got fat!!");
      }
    } else if(number2 > 9) {
      System.out.print("You won!");
    } else {
      if(number1 > number2){
        System.out.println("You won!");
      } else if(number1 == number2){
        System.out.println("Both won!"); //Since im a happy person.
      } else {
        System.out.println("You lost!");
      }
    }
  }

  public static int randomNumber(int number) {
    Random rnd = new Random();
    int dieRoll;
    dieRoll = rnd.nextInt(6) + 1;
    return dieRoll;
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int dieRoll;
    int sumPlayer;
    int sumComputer;
    char answer;

    System.out.println("Playing a game");
    System.out.println("=================");
    System.out.println();
    System.out.print("Ready to play? (Y/N) ");
    answer = scan.next().charAt(0);

    if (answer == 'y' || answer == 'Y') {
      dieRoll = randomNumber(6);
      sumPlayer = dieRoll;
      System.out.println("You rolled " + dieRoll);
      System.out.print("Would you like to roll again? (Y/N) ");
      answer = scan.next().charAt(0);

      if (answer == 'y' || answer == 'Y') {
        dieRoll = randomNumber(6);
        sumPlayer += dieRoll;
        System.out.println("You rolled " + dieRoll + " and in total you have " + sumPlayer);
      }
      //Computers turn.
      dieRoll = randomNumber(6);
      sumComputer = dieRoll;
      System.out.println("The computer rolled " + dieRoll);
      if(sumComputer <= 4) {
        dieRoll = randomNumber(6);
        sumComputer += dieRoll;
        System.out.println("The computer rolls again and gets " + dieRoll + " and in total " + sumComputer);
      }
      // Handle Result.
      compareResult(sumPlayer, sumComputer);
    } else {
      System.out.println("Have a nice day!");
    }

    scan.close();
  }
}
