package Lection4;

import java.util.Scanner;

public class PremishionForWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        System.out.println("Please enter your age:");
        if (age >= 16) {
            System.out.println("You are eligible to work.");
        } else
            System.out.println("You are not eligible to work." );
    }
}
