package assignment1.programs;

import java.util.Scanner;

public class Hex2Dec {
    public static int hexToDecimal(String hex) {
        hex = hex.toUpperCase();
        String hexString = "0123456789ABCDEF";
        int hexDecimal = 0;
        int hexdigit;
        char hexChar;

        for (int i = 0; i < hex.length(); i++) {
            hexChar = hex.charAt(i);
            hexdigit = hexString.indexOf(hexChar);
            hexDecimal = 16 * hexDecimal + hexdigit;
        }
        return hexDecimal;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String hexNumber;
        int hexDecimal;

        System.out.print("Enter a hex number: ");
        hexNumber = scan.nextLine();
        hexDecimal = hexToDecimal(hexNumber);
        System.out.println("The decimal value for " + hexNumber + " is " + hexDecimal + ".");

        scan.close();
    }
}
