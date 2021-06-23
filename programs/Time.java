package assignment1.programs;

import java.util.Scanner;

public class Time {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int userInput;

    System.out.println("Insert seconds");
    userInput = scan.nextInt();
    int hours = userInput / 3600;
    int minutes = (userInput%3600)/60;
    int seconds = (userInput%3600)%60;
    System.out.println("You entered: " + userInput);
    System.out.println("It is the same as: " + hours + "h " + minutes + "m " + seconds+ "s");

    scan.close();
  }
}
