package assignment1.programs;

import java.util.Scanner;

public class DangerousWork {
  public static int calculateDays(int income){
    double daysSalary = 0.01;
    int days = 0;

    while(daysSalary < income){
      daysSalary *= 2;
      days++;
    }
    return days;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int wantedIncome;
    int daysToWork;

    System.out.print("How much would you like to earn? ");
    wantedIncome = scan.nextInt();
    daysToWork = calculateDays(wantedIncome);
    System.out.print("You will have your money in " + daysToWork + " days.");
    
    scan.close();
  }
}

// Fråga om System.out.print("You will have your money in " + calculateDays(wantedIncome); + " days.");
// Istället för skapa variabel. Vad är "bäst"?
