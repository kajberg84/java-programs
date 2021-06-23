package assignment1.programs;

import java.util.Random;
import java.util.Scanner;

public class GameSRP {

  public static String comparingSRP(int user, int computer){
    if (user == computer){
      return "draw";
    } else if ((user == 1 && computer == 3) || (user == 2 && computer == 1) || (user == 3 && computer == 2)) {
      return "user";
    } else {
      return "comp";
    }
  }

  public static Boolean checkInput(int inputSRP){
    return (inputSRP >= 0 && inputSRP <= 3);
  }
  

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Random rnd = new Random();
    int userChoice = 1;
    int computerChoice;
    String result;
    int draws = 0;
    int userWins = 0;
    int compWins = 0;
    Boolean userInput;
    String [] picked = {"scissor", "rock", "paper"}; 

  while(userChoice != 0){
    do{
      System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");
      userChoice = scan.nextInt();
      userInput = checkInput(userChoice);
    } while(!userInput);

    if(userChoice != 0){
      computerChoice = rnd.nextInt(3) + 1;
      result = comparingSRP(userChoice, computerChoice);
      if(result.equals("draw")){
        System.out.println("It´s a draw!");
        draws++;
      } else if(result.equals("user")) {
        System.out.println("You won, computer had " + picked[computerChoice - 1] + "!");
        userWins++;
      } else {
        System.out.println("You lost, computer had " + picked[computerChoice - 1] + "!");
        compWins++;
      }
    }
}

  System.out.println("Score: " + userWins + " (you) " + compWins + " (computer) " + draws + " (draw).");

  scan.close();
  }
}
