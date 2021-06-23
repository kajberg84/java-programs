package assignment1.programs;

import java.util.Scanner;

public class PrintCalendar {
  public static void calenderOutPut(int y, int m, int nrOfDays, int startingDay) {
    int dayCounter = 1;
  System.out.println(monthToString(m - 1) + " " + y);
  System.out.println("----------------------------");
  System.out.println("Mon Tue Wed Thu Fri Sat Sun");

  for (int i = 0; i < 6; i++) {
    for (int j = 0; j < 7; j++) {
      if(startingDay - 1 > 0) {
        System.out.print("    ");
        startingDay--;
      } else {
        if(dayCounter < 10){
          System.out.print(" " + dayCounter + "  ");
        } else  if(dayCounter <= nrOfDays) {
          System.out.print(dayCounter + "  ");
        } else {
          System.out.print("    ");
        }
        dayCounter++;
      }
    }
    System.out.println();
  }
}

public static String monthStartingDay(int y, int m) {
  int h;
  int d = 1;
  String[] weekDay = { "saturday", "sunday", "monday", "tuesday", "wednesday", "thursday", "friday" };
  if (m == 1 || m == 2) {
    y -= 1;
    m += 12;
  }
  int k = y % 100;
  int j = y / 100;
  h = (d + (26 * (m + 1)) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
  return weekDay[h];
}

public static Boolean checkLeapYear(int leapYear){
  Boolean isLeapYear = false;
  if (leapYear % 4 == 0) {
    if (leapYear % 100 == 0) {
      if (leapYear % 400 == 0) {
        isLeapYear = true;
      } else {
        isLeapYear = false;
      }
    } else {
      isLeapYear = true;
    }
  } else {
    isLeapYear = false;
  }
  return isLeapYear;
}

public static Boolean checkYear(int year){
  return (year > 1800);
}

public static Boolean checkMonth(int month){
  return (month >= 1 && month <= 12);
}

  public static String monthToString(int convertMonth){
    String [] months = {"January", "February", "March", "April", "May", "June", "july", "August", "September", "October", "November", "December"};
    return  months[convertMonth];
  }

  public static int convertDayToNumber(String day) {
    int numberOfDay;

    if (day.equals("monday")) {
      numberOfDay = 1;
    } else if (day.equals("tuesday")) {
      numberOfDay = 2;
    } else if (day.equals("wednesday")) {
      numberOfDay = 3;
    } else if (day.equals("thursday")) {
      numberOfDay = 4;
    } else if (day.equals("friday")) {
      numberOfDay = 5;
    } else if (day.equals("saturday")) {
      numberOfDay = 6;
    } else {
      numberOfDay = 7;
    }
    return numberOfDay;
  }

  public static int monthsNumberOfDays(int month){
    int[] dayEveryMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    return dayEveryMonth[month - 1];
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int year;
    int month;
    String day;
    int daysThisMonth;
    Boolean checkDate= false;

    do {
      System.out.print("Enter a year after 1800: ");
      year = scan.nextInt();
      checkDate = checkYear(year);
    } while(!checkDate);

    do {
      System.out.print("Enter a month (1-12): ");
      month = scan.nextInt();
      checkDate = checkMonth(month);
    } while(!checkDate);

    day = monthStartingDay(year, month);
    daysThisMonth = monthsNumberOfDays(month);

    if (month == 2 && checkLeapYear(year) == true) {
      daysThisMonth = 29;
      }

    calenderOutPut(year, month, daysThisMonth, convertDayToNumber(day));

    scan.close();
  }
}
