package assignment1.programs;

import java.util.Scanner;

public class Diamonds {
   public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int diamondRows = 1;
     int i;
     int j;

     while (diamondRows > 0) {
      System.out.print("Give a positive number: ");
      diamondRows = scan.nextInt();
      // Pyramid.
      for (i = 0; i <= diamondRows; i++) {
        for (j = 1; j <= diamondRows - i; j++) {
          System.out.print(" ");
        }
        for (j = 1; j <= 2 * i - 1; j++) {
          System.out.print("*");
        }
        System.out.println("");
      }
      // Reversed pyramid.
      for (i = diamondRows - 1; i >= 1; i--) { 
        for (j = 1; j <= diamondRows - i; j++) {
          System.out.print(" ");
        }
        for (j = 1; j <= 2 * i - 1; j++) {
          System.out.print("*");
        }
        System.out.println("");
      }
    }

     scan.close();
   }
}
