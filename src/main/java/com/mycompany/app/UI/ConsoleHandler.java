package main.java.com.mycompany.app.UI;

import java.util.Scanner;

public class ConsoleHandler {
    public static boolean handleInput() {
        Scanner reader = new Scanner(System.in);
        System.out.println("*** Menu ***");
        System.out.println("1. Add a product");

        System.out.println("0. End program");
        System.out.println("Enter a number :");
        int n = reader.nextInt();
        switch(n) {
            case 0:
                return false;
            case 1:

                break;
        }
        reader.close();
        return true;
    }
}
