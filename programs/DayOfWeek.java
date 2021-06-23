package assignment1.programs;

import java.util.Scanner;

public class DayOfWeek {

public static int calculateWeekDay(int y, int m, int d){
  int h; 

  if(m == 1 || m == 2){
    y -= 1;
    m += 12;
  }  
  int k = y % 100;
  int j = y / 100;

  h = (d + (26*(m+1))/10 + k + k/4 + j/4 + 5*j) % 7;
  return h;
}

public static Boolean checkYear(int year){
  return (year > 1800);
}

public static Boolean checkMonth(int month){
  return (month >= 1 && month <= 12);
}

public static Boolean checkDay(int day){
  return (day >= 1 && day <= 31);
}

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Boolean checkDate = false;
    int year;
    int month;
    int day;
    int weekNr;
    String [] weekDay = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    do {
      System.out.print("Enter year: ");
      year = scan.nextInt();
      checkDate = checkYear(year);
    } while(!checkDate);

    do {
      System.out.print("Enter month (1-12): ");
      month = scan.nextInt();
      checkDate = checkMonth(month);
    } while(!checkDate);

    do {
      System.out.print("Enter day (1-31): ");
      day = scan.nextInt();
      checkDate = checkDay(day);
    } while(!checkDate);

    weekNr = calculateWeekDay(year, month, day);
    System.out.println("Day of week is " + weekDay[weekNr]);

    scan.close();
  }
}
